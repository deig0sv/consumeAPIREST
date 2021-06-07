package com.consumeApiRest.client;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public class AbstractClient {
    private String url;
    private String contextPath;
 
    private static final Logger log = Logger.getLogger(AbstractClient.class.getName());
 
    public AbstractClient(String url, String contextPath) {
        this.url = url;
        this.contextPath = contextPath;
    }
 
    protected WebTarget createClient(String path) {
        String assembledPath = assembleEndpoint(path);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(assembledPath);
        return target;
    }
 
    private String assembleEndpoint(String path) {
        String endpoint = url.concat(contextPath).concat(path);
        log.info(String.format("Calling endpoint %s", endpoint));
        return endpoint;
    }
}