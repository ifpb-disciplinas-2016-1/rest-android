package ifpb.ads.pos;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/09/2016, 00:30:21
 */
@Path("android")
public class AndroidResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "{ping}";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String json(
            @FormParam("nome") String nome,
            @FormParam("idade") int idade) {
        return "{"
                + "\"nome\":\"" + nome + "\","
                + "\"idade\":" + idade
                + "}";
    }
}
