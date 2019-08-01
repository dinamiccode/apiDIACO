package api;

import com.diaco.modelo.Departamento;
import com.diaco.modelo.Municipio;
import com.diaco.modelo.category;
import com.diaco.modelo.diaco_diaco_name_template;
import com.diaco.modelo.diaco_precio;
import com.diaco.modelo.diaco_vaciadocba;
import com.diaco.modelo.vaciado;
import com.diaco.servicios.InterfaceDiaco;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/diaco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class DepartamentoREST {

    String message;
    
    @Inject
    private InterfaceDiaco interfaceDiaco;
    
    @GET
    @Path("/departamentos")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Departamento> getDepartamentos() {
        return interfaceDiaco.getDepartamentos();
    }
    
    @GET
    @Path("/depa")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getDepa(){
        return interfaceDiaco.getDepartamentos().toString();
    }
    
    @GET
    @Path("/locationCategory")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getLocationCategory(){
        return interfaceDiaco.getDepartamentos().toString();
    }
    
    @GET
    @Path("/municipios/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Municipio> getMunicipioId(@PathParam("id") String id) {
        return interfaceDiaco.getMunicipioId(id);
    }
    
    @GET
    @Path("/p")
    @Produces(MediaType.APPLICATION_JSON)
    public List<diaco_vaciadocba> getPre(){
        return interfaceDiaco.getPrecio();
    }
    
    @GET
    @Path("/pre/{categoria}/{municipio}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrecio(@PathParam("categoria") Integer categoria,@PathParam("municipio") Integer municipio){
        return interfaceDiaco.getvaciaso(categoria,municipio).toString();
    }
    
    @GET
    @Path("/precio/{categoria}/{municipio}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getDatosPrecios(@PathParam("categoria") Integer categoria,@PathParam("municipio") Integer municipio){
        return interfaceDiaco.getvaciaso(categoria, municipio).toString();
    }
    
    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getCategorias(){
        return interfaceDiaco.getCategory().toString();
    }
    
    
    
    //**********************JOIN NUEVOS
    
    @GET
    @Path("/pp")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getDataPrecio(){
        return interfaceDiaco.getDataPrecio().toString();
    }
    
    @GET
    @Path("/pp2")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getDataPrecio2(){
        return interfaceDiaco.getDataPrecio2().toString();
    }
    
    
    @GET
    @Path("/pp3")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getPlantilla(){
        return interfaceDiaco.getPlantilla().toString();
    }
    
    
    
    
//    public List<Municipio> getMunicipios(@PathParam("id") String id) {
//        return interfaceDiaco.getMunicipios();
//    }
    
    
    
//    @POST
//    @Path("/mensaje")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response echo(Departamento dep) {
//        
//        String message = "Product created : " + dep.getNombre_departamento();
//        return Response.ok().entity(message == null ? "no message" : message).build();
//    }
}
