/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.productClient;
import entity.Productmaster;
import java.io.Serializable;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "productManageBean")
@RequestScoped
public class productManageBean implements Serializable {

    productClient pcl = new productClient();
    Response rs;
    Collection<Productmaster> products;
    GenericType<Collection<Productmaster>> gproducts;
    Productmaster p = new Productmaster();
    
    int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    

    public Productmaster getP() {
        return p;
    }

    public void setP(Productmaster p) {
        this.p = p;
    }
    
    public String addProduct()
    {
        System.out.println(String.valueOf(cid));
        String productName = p.getProductName();
        int price = p.getPrice();
        pcl.addProduct(productName, String.valueOf(price), String.valueOf(cid));
        
        return "index.xhtml";
    }
    
    public Collection<Productmaster> getAllProduct()
    {
        rs = pcl.getAllProducts(Response.class);
        products = rs.readEntity(gproducts);
        return products;
    }
    
}
