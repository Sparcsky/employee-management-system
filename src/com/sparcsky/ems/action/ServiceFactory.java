package com.sparcsky.ems.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static Map<String, Service> services = new HashMap<>();

    public static Service getAction(HttpServletRequest request) {

        String path = request.getServletPath();

        if (!services.containsKey(path)) {
            if (path.equals("/login")) {
                services.put(path, new LoginService());
            } else if (path.equals("/register")) {
                services.put(path, new SignUpService());
            } else if (path.equals("/home")) {
                services.put(path, new HomeService());
            }
        }

        return services.get(path);
    }
}
