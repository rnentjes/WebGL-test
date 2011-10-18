import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

/**
 * User: rnentjes
 * Date: 10/18/11
 * Time: 8:55 PM
 */
public class HttpServer {

    public HttpServer() throws Exception {
        Server server = new Server();
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(9000);
        server.addConnector(connector);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        //resource_handler.setWelcomeFiles(new String[]{ "index.html" });

        resource_handler.setResourceBase("./web");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    public static void main(String [] args) throws Exception {
        new HttpServer();
    }

}


