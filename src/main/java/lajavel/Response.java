package lajavel;

import io.javalin.http.Context;
import io.javalin.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Map;

public class Response {
    private final Context context;
    private final HttpServletRequest response;

    public Response(Context context) {
        this.context = context;
        this.response = context.req;
    }

    // Response methods
    public void result(String response) {
        context.result(response);
    }

    public void result(byte[] bytes) {
        context.result(bytes);
    }

    public void result(InputStream input) {
        context.result(input);
    }

    public void contentType(String type) {
        context.contentType(type);
    }

    public void header(String name, String value) {
        context.header(name, value);
    }

    public void redirect(String path, int code) {
        context.redirect(path, code);
    }

    public void status(int code) {
        context.status(code);
    }

    public void cookie(String name, String value, int maxAge) {
        context.cookie(name, value, maxAge);
    }

    public void cookie(Cookie cookie) {
        context.cookie(cookie);
    }

    public void removeCookie(String name, String path) {
        context.removeCookie(name, path);
    }

    public void json(Object object) {
        context.json(object);
    }

    public void jsonStream(Object object) {
        context.jsonStream(object);
    }

    public void html(String html) {
        context.html(html);
    }
}