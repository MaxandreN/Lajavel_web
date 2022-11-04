package lajavel;

import io.javalin.http.Context;

import java.lang.reflect.Method;

public class Route {

    public static void register(HttpVerb httpVerb, String routerName, Class <?> controllerClass, String methodName){
        Application app = Application.getInstance();



        switch (httpVerb){
            case GET -> app.server.get(routerName, context -> {
                        InvokeController(context, controllerClass, methodName);
                    });
            case POST -> app.server.post(routerName, context -> {
                        InvokeController(context, controllerClass, methodName);
                    });
        }
    }

    private static void InvokeController(Context context, Class <?> controllerClass, String methodName){
        Response response = new Response(context);

        try {
            Controller controller = (Controller) controllerClass.getDeclaredConstructor().newInstance();
            Method method = controllerClass.getMethod(methodName, Response.class);
            method.setAccessible(true);
            method.invoke(controller, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
