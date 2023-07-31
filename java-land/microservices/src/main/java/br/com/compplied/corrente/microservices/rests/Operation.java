package br.com.compplied.corrente.microservices.rests;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/operation")
public class Operation {
	
	@POST
    @Path("add")
    @Produces(MediaType.TEXT_PLAIN)
    public String add() {
        return "Test";
    }

}
