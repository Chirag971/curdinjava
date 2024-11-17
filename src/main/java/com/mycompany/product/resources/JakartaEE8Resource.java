package com.mycompany.product.resources;

import ejb.productBeanLocal;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @EJB productBeanLocal pbl;
    
    @POST
    @Path("/addProduct/{productName}/{price}/{cid}")
    public void addProduct(@PathParam("productName") String productName,@PathParam("price") int price,@PathParam("cid") int cid)
    {
        pbl.addProduct(productName, price, cid);
    }
    
    @GET
    @Path("/getallproduct")
    @Produces("application/json")
    public Collection<Productmaster> getAllProducts() {
        return pbl.getAllProduct();
    }
}
