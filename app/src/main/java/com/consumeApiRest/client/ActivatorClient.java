package com.consumeApiRest.client;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.consumeApiRest.endpoints.ApplicationEndpoint;
import com.consumeApiRest.error.ServiceException;
import com.consumeApiRest.model.GenericResponse;
import com.consumeApiRest.model.Product;


public class ActivatorClient extends AbstractClient {
    private static final Logger log = Logger.getLogger(ActivatorClient.class.getName());
 
    public ActivatorClient(String url, String contextPath) {
        super(url, contextPath);
    }
 
    public Product getProductById(String id) throws ServiceException {
        log.info("Getting product by id");
        WebTarget client = createClient(ApplicationEndpoint.getProductById(id));
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        Product result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(Product.class);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
    
    public List<Product> getAllProduct() throws ServiceException {
        log.info("Getting all products");
        WebTarget client = createClient(ApplicationEndpoint.getAllProduct());
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        List<Product> result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(new GenericType<List<Product>>(){});
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
    
    public GenericResponse createProduct(Product product) throws ServiceException {
        log.info("Creating product");
        WebTarget client = createClient(ApplicationEndpoint.createNewProduct());
        Response response = client.request(MediaType.APPLICATION_JSON)
        		.accept(MediaType.TEXT_PLAIN_TYPE)
        		.post(Entity.json(product));
        log.info("Status " + response.getStatus());
        GenericResponse result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(GenericResponse.class);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
    
    public Product activateProduct(Product product) throws ServiceException {
        log.info("Activating Product");
        WebTarget client = createClient(ApplicationEndpoint.activateProduct());
        Response response = client.request(MediaType.APPLICATION_JSON)
        		.put(Entity.json(product));
        log.info("Status " + response.getStatus());
        Product result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(Product.class);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
    
    public Product getRipplePrice() throws ServiceException {
        log.info("Getting ripple price");
        WebTarget client = createClient(ApplicationEndpoint.getCoinPrice("xrp_mxn"));
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        Product result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(Product.class);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
 
    public Product getBitcoinPrice() throws ServiceException {
        log.info("Getting ripple price");
        WebTarget client = createClient(ApplicationEndpoint.getCoinPrice("btc_mxn"));
        Response response = client.request(MediaType.APPLICATION_JSON).get();
        log.info("Status " + response.getStatus());
        Product result = null;
        Integer status = response.getStatus();
        if (Status.OK.getStatusCode() == status) {
            result = response.readEntity(Product.class);
        } else {
            throw new ServiceException(response.readEntity(String.class), status);
        }
        return result;
    }
 
}