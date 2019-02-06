package pizzapackage;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "pizza")
@RequestScoped
public class PizzaController {

    @Inject
    PizzaManager pm;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String name;
    private String description;
    private double price;
    private List<Pizza> allPizzas;

    public void submit() {
        Pizza p = new Pizza(name, description, price);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }

    public void removeByPizza(Pizza p) {

        pm.removeAPizza(p);
            
         fillArray();

        
    }
    
    
    public void removeById(){
    
        pm.remove(id);
        
        fillArray();
    
    }

    @PostConstruct
    public void fillArray() {

        this.allPizzas = pm.getAllPizzas();

    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PizzaController() {
    }

}
