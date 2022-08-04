package fr.m2i.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class WelcomeService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		
		return "Hello, the world!";
	}
	
}
