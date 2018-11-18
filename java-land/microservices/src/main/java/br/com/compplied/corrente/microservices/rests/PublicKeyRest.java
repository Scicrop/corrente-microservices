package br.com.compplied.corrente.microservices.rests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/public-key")
public class PublicKeyRest {

    @GET
    @Path("openpgp")
    @Produces(MediaType.TEXT_PLAIN)
    public String openpgp() {
        return "Test";
    }
}