package first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello(@QueryParam("Steven") String prenom, @QueryParam("DE CARVALHO") String nom) {
    return "Hello "+prenom+" "+nom;
  }
  
}
