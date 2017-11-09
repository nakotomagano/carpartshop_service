package com.mycompany.carshop.port.impl;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.repository.CarSystemDAO;

//The Java class will be hosted at the URI path "/helloworld"
@WebService()
@Path("/")
public class RestService {

    @Context
    private ServletContext sctx;          // dependency injection

    public RestService() {}

    @GET
    @Path("/systems/{id: \\d+}")
    @Produces("text/plain")
    public String getSystem(@PathParam("id") int id) {
        CarSystemDAO csDao = new CarSystemDAO();
        return csDao.getSystemById(id).toString();
    }

    @GET
    @Path("/systems/xml/carSystem/{id: \\d+}")
    @Produces({MediaType.APPLICATION_XML})
    public Response getXml(@PathParam("id") int id) {
        //checkContext();
        CarSystemDAO csDao = new CarSystemDAO();
        return Response.ok(csDao.getSystemById(id), "application/xml").build();
    }
    @GET
    @Path("/systems/xml/allSystems")
    @Produces({MediaType.APPLICATION_XML})
    public Response getAllCarSystemsXml() {
        //checkContext();
        CarSystemDAO csDao = new CarSystemDAO();
        return Response.ok(csDao.getAllSystems(), "application/xml").build();
    }

    @GET
    @Path("/systems/json/carSystem/{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCarSystemJson(@PathParam("id") int id) {
        //checkContext();
        CarSystemDAO csDao = new CarSystemDAO();
        CarSystem carSystem = csDao.getSystemById(id);
        String jsonCarSystem = toJson(carSystem);
        return Response.ok(jsonCarSystem, "application/xml").build();
    }
    @GET
    @Path("/systems/json/allSystems")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllCarSystemsJson() {
        //checkContext();
        CarSystemDAO csDao = new CarSystemDAO();
        return Response.ok(toJson(csDao.getAllSystems()), "application/xml").build();
    }

    // CarSystem --> JSON document
    private String toJson(Object obj) {
        String json = "If you see this, there's a problem.";
        try {
            json = new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) { }
        return json;
    }


    //POSTS:

    //Car System:
    @POST
    @Path("/systems/add/{systemName}")
    @Produces("text/plain")
    public Response addSystem(@PathParam("systemName") String systemName) {
        CarSystemDAO csDao = new CarSystemDAO();
        CarSystem carSystem = new CarSystem();
        carSystem.setSystemName(systemName);
        try {
            csDao.addNewSystem(carSystem);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int id = carSystem.getSystemId();
        String msg = "Car System id: " + id;
        return Response.ok(msg, "text/plain").build();
    }

}
