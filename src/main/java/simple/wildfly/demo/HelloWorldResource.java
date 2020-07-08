package simple.wildfly.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/demo")
public class HelloWorldResource {

	private static final Logger LOG = Logger.getLogger(HelloWorldResource.class.getName());

	// Access at: http://127.0.0.1:8090/simple-wildfly-demo/swd/demo
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String helloWorld() {
		LOG.info("shouting hello world! ... ");

		return "Hello World from " + getHostname();
	}

	private String getHostname() {
		try {
			String hostname = InetAddress.getLocalHost().getHostName() + " ("
					+ InetAddress.getLocalHost().getHostAddress() + ")";
			return hostname;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "(unknown)";
		}
	}

}