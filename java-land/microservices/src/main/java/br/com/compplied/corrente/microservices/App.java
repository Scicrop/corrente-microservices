package br.com.compplied.corrente.microservices;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import br.com.compplied.corrente.microservices.rests.PublicKeyRest;

public class App 
{
    public static void main( String[] args )
    {
    	ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        
        jerseyServlet.setInitParameter(
           "jersey.config.server.provider.classnames",
           PublicKeyRest.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
            jettyServer.destroy();
        }
    }
}
