package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8003);

        // Important: Create HTTP connector
        tomcat.getConnector();

        // Create context
        Context context = tomcat.addContext(
                "",
                null);

        // Register servlet
        Tomcat.addServlet(context, "servlet1", new HelloServlet());

        // Map URL
        context.addServletMapping("/hello", "servlet1");

        // Start Tomcat
        tomcat.start();

        System.out.println("Tomcat started successfully!");

        // Keep server running
        tomcat.getServer().await();
    }
}
