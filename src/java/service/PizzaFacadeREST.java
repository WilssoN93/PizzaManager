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
@Path("pizza")
public class PizzaFacadeREST {

    @Inject
    PizzaManager pm;

    public PizzaFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pizza p) {
        pm.addPizza(p);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Pizza p) {

        pm.update(p);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
      pm.remove(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pizza find(@PathParam("id") Integer id) {
        return pm.getPizza(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pizza> findAll() {
        return pm.getAllPizzas();
    }

}
