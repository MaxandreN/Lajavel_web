package lajavel;

import org.eclipse.jetty.util.log.Logger;

import javax.management.ObjectName;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {

    public static String make(String viewName, Map.Entry<String, Object>... objects) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        String rawHtml = View.getViewContentFromName(viewName);
        //String rawHtmlFooter = View.getViewContentFromName("footer");
        //String rawHtmlHeader = View.getViewContentFromName("header");
        StringBuffer sb = new StringBuffer();

//        if(rawHtml.contains("{%") && rawHtml.contains("%}")){
//            Matcher matcheForeach = Pattern.compile("\\{\\%(.*?)\\%\\}").matcher(rawHtml);
//            while (matcheForeach.find()){
//
//
//                Log.info(matcheForeach.group(1).replaceAll("\\s", ""));
//            }
//        }
        //sb.append(rawHtmlHeader);

        Matcher m = Pattern.compile("\\{\\{(.*?)\\}\\}").matcher(rawHtml);

        while (m.find()){
            String rawStringOfAnObject = m.group(1).replaceAll("\\s", ""); //remove space
            String[] objetAndProperty = rawStringOfAnObject.split("\\.");

            String objectName = objetAndProperty[0];
            String propertyName = objetAndProperty[1];

            for (Map.Entry<String, Object> entry : objects){
                if(entry.getKey().equals(objectName)){
                    m.appendReplacement(sb, View.getValueOf(objectName, propertyName, entry.getValue()));
                    break;
                }
            }
        }
        //sb.append(rawHtmlFooter);

        m.appendTail(sb);
        return sb.toString();
    }

    public static String getProperty(Object obj, String property){
        String returnValue = null;

        try {
            Field field = obj.getClass().getDeclaredField(property);
            field.setAccessible(true);
            returnValue = field.get(obj).toString();
        }
        catch (Exception e){

        }
        return returnValue;
    }

    public static String getMethod(Object obj, String methodName) {
        String returnValue = null;

        try {
            Method method = obj.getClass().getMethod(methodName);
            method.setAccessible(true);
            returnValue = method.invoke(obj).toString();
        }
        catch (Exception e){
           throw new RuntimeException(methodName + " " + obj.getClass().getSimpleName() + " " + e);
        }

        return returnValue;
    }

    public static String getViewContentFromName(String viewName){
        String body;
        URL resource = View.class.getClassLoader().getResource("views/"+ viewName +".html");
        if(resource == null) {
            throw new RuntimeException("View file not found ! (cf getViewContentFromName)");
        }
        try {
            return Files.readString(Path.of(resource.toURI()), StandardCharsets.UTF_8);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public static String getValueOf(String objectName, String propertyName, Object object){

        boolean isMethod = false;
        if(propertyName.contains("()")){
            isMethod = true;
            propertyName = propertyName.replace("()", "");
        }

        if(!isMethod){
            Object propertyValue = getProperty(object, propertyName);
            return propertyName.toString();
        }else{
            return getMethod(object, propertyName);
        }
    }
}
