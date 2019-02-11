

package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pizzapackage.Pizza;
import pizzapackage.PizzaManager;


@Stateless
@Path("rest")
public class RestService {
    
    @Inject
    PizzaManager pm;
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Pizza> getAll(){
    
    return pm.getAllPizzas();
        
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void add(Pizza p){
    
        pm.addPizza(p);
    
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public void edit(Pizza p){
    
        pm.update(p);
    }
    
    
    @GET
    @Path("id")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void getById(@PathParam("id") Integer id){
        
    pm.getPizza(id);
    
    }
    
    @DELETE
    @Path("id")
    public void deleteById(@PathParam("id") Integer id){
        
    pm.remove(id);
    
    }

}
