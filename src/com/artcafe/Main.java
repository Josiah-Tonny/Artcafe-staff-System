package com.artcafe;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
        /**
         * @param args
         * @throws Exception
         */
        public static void main(String[] args) throws Exception {
            // Create the Jetty server on port 8080
            Server server = new Server(8080);

            // Create a WebAppContext for the Jetty server
            WebAppContext context = new WebAppContext();
            context.setResourceBase("src/main/webapp");
            context.setContextPath("/");

            // Set the context handler for the server
            server.setHandler(context);

            // Start the server
            server.start();
            server.join(); // Optional join to wait for server thread to complete
        }
}
