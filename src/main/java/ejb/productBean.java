/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Catagorymaster;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LENOVO
 */
@Stateless
public class productBean implements productBeanLocal {
    @PersistenceContext(unitName = "productPU")
    EntityManager em;   
    
    Productmaster p = new Productmaster();
         

    @Override
    public void addProduct(String productName, int price, int cid) {
        Catagorymaster c = (Catagorymaster) em.find(Catagorymaster.class, cid);
        Collection<Productmaster> products = c.getProductmasterCollection();
        p.setProductName(productName);
        p.setPrice(price);
        p.setCid(c);
        products.add(p);
        
        c.setProductmasterCollection(products);
        
        em.persist(p);
        em.merge(c);
    }

    @Override
    public void editProduct(int pid, String productName, int price, int cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProduct(int pid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Productmaster> getAllProduct() {
        return em.createNamedQuery("Productmaster.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
