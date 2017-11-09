package com.mycompany.carshop.port.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.repository.CarSystemDAO;
import com.mycompany.carshop.repository.MemberDao;
import com.mycompany.carshop.repository.PartDao;

@Path("/")
public class RestService {

    public RestService() {}

    //GET:

    //Car System:
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
    public CarSystem getSystemXml(@PathParam("id") int id) {
        CarSystemDAO csDao = new CarSystemDAO();
        return csDao.getSystemById(id);
    }

    //Matrix param example:
    @GET
    @Path("/systems/query/xml/user")
    @Produces({MediaType.APPLICATION_XML})
    public Member getUserMatrixXml(@MatrixParam("email") String email, @MatrixParam("password") String password) {
        MemberDao memberDao = new MemberDao();
        return memberDao.getMemberByEmailAndPassword(email, password);
    }
    //Query param example:
    @GET
    @Path("/systems/query/xml/carSystem")
    @Produces({MediaType.APPLICATION_XML})
    public CarSystem getSystemQueryXml(@QueryParam("id") int id) {
        CarSystemDAO csDao = new CarSystemDAO();
        return csDao.getSystemById(id);
    }

    @GET
    @Path("/systems/xml/allSystems")
    @Produces({MediaType.APPLICATION_XML})
    public CarSystem[] getAllCarSystemsXml() {
        CarSystemDAO csDao = new CarSystemDAO();
        return csDao.getAllSystems();
    }

    @GET
    @Path("/systems/json/carSystem/{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public CarSystem getCarSystemJson(@PathParam("id") int id) {
        CarSystemDAO csDao = new CarSystemDAO();
        CarSystem carSystem = csDao.getSystemById(id);
        String jsonCarSystem = toJson(carSystem);
        return carSystem;
    }
    @GET
    @Path("/systems/json/allSystems")
    @Produces({MediaType.APPLICATION_JSON})
    public CarSystem[] getAllCarSystemsJson() {
        CarSystemDAO csDao = new CarSystemDAO();
        return csDao.getAllSystems();
    }

    // CarSystem --> JSON document
    private String toJson(Object obj) {
        String json = "If you see this, there's a problem.";
        try {
            json = new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) { }
        return json;
    }

    @GET
    @Path("/systems/xml/part/{id: \\d+}")
    @Produces({MediaType.APPLICATION_XML})
    public Part getPartXml(@PathParam("id") int id) {
        PartDao partDao = new PartDao();
        return partDao.getPartById(id);
    }
    @GET
    @Path("/systems/xml/allParts")
    @Produces({MediaType.APPLICATION_XML})
    public Part[] getAllPartsXml() {
        PartDao partDao = new PartDao();
        return partDao.getAllParts();
    }

    @GET
    @Path("/systems/json/part/{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Part getPartJson(@PathParam("id") int id) {
        PartDao partDao = new PartDao();
        Part part = partDao.getPartById(id);
        return part;
    }
    @GET
    @Path("/systems/json/allParts")
    @Produces({MediaType.APPLICATION_JSON})
    public Part[] getAllPartsJson() {
        PartDao partDao = new PartDao();
        return partDao.getAllParts();
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


    //Part:

    @POST
    @Path("/parts/json/add/{part}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public Response addPartJson(InputStream incomingData) { //? @PathParam("part") Part part
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }

        JSONObject jsObj = new JSONObject(crunchifyBuilder.toString());
        Part p = new Part();

        String partName = jsObj.getString("partName");
        p.setPartName(partName);

        float price = jsObj.getBigDecimal("price").floatValue();
        p.setPrice(price);

        PartDao partDao = new PartDao();
        partDao.addNewPart(p);

        String msg = "New part id: " + p.getPartId();
        return Response.ok(msg, "text/plain").build();
    }
}
