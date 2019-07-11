package api;

import com.diaco.modelo.Departamento;
import com.diaco.servicios.InterfaceDiaco;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/diaco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class DepartamentoREST {

    @Inject
    private InterfaceDiaco interfaceDiaco;
    
    @GET
    @Path("/departamentos")
    @Produces(MediaType.APPLICATION_JSON)
    
    public List<Departamento> getDepartamentos() {
        return interfaceDiaco.getDepartamentos();
    }
    
}
