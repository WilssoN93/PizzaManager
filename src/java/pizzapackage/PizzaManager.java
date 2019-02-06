package pizzapackage;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PizzaManager {

    @PersistenceContext
    public EntityManager em;

    public void addPizza(Pizza p) {

        em.persist(p);

    }

    public Pizza getPizza(Integer id) {

        return em.find(Pizza.class, id);

    }

    public void update(Pizza p) {

        em.merge(p);

    }

    public void remove(Integer id) {

        Pizza p = em.find(Pizza.class, id);

        if (getAllPizzas().contains(p)) {
            em.remove(em.merge(p));
        }

    }

    public void removeAPizza(Pizza p) {

        if (getAllPizzas().contains(p)) {
            em.remove(em.merge(p));
        }

    }

    public List<Pizza> getAllPizzas() {

        Query q = em.createQuery("Select p from Pizza p");

        return q.getResultList();

    }

}
