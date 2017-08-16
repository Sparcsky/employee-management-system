package com.sparcsky.ems;

import com.sparcsky.ems.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static Map<String, Service> services = new HashMap<>();

    public static Service getAction(HttpServletRequest request) {

        String path = request.getServletPath();

        System.out.println("ACTION NAME:     " + path);

        if (!services.containsKey(path)) {
            if (path.equals("/login")) {
                services.put(path, new LoginService());
            }
        }

        return services.get(path);
    }


}
