package com.suren.learn;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Authenticated
public class MyResource {

    private static List<Student> students = null;

    static{
        students = new ArrayList<Student>();
        students.add(new Student("1", "suren", "siva", 27));
        students.add(new Student("2", "kirthi", "suren", 26));
        students.add(new Student("3", "sadhana", "suren", 1));
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String GetText() {
        return "Got it!";
    }

    @GET
    @Path("get/{val}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getWithPathParam(@PathParam("val") String val) {
        return val + " Is Great";
    }

    @GET
    @Path("getq")
    @Produces(MediaType.TEXT_PLAIN)
    public String getWithTwoQueryParam(
            @QueryParam("name") String name,
            @QueryParam("age") String age) {
        return "Name is : " + name + " And Age is : " + age;
    }


    @GET
    @Path("getjson")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getJsonObject() {
        return new Student("1", "suren", "siva", 27);
    }

    @GET
    @Path("getxml")
    @Produces(MediaType.APPLICATION_XML)
    public Student getXmlObject() {
        return new Student("1", "suren", "siva", 27);
    }

    @GET
    @Path("getjsonlist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getJsonObjectList() {
        return students;
    }

    @GET
    @Path("getxmllist")
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getXmlObjectList() {
        return students;
    }

    @GET
    @Path("getstudentxml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getStudentXmlFromIdPath(@PathParam("id") String id) {
//            if((id == null) || (id.length() == 0)){
//                            return Response.serverError().entity("Cannot Be Empty").build();
//            }
        Student student = null;
        for(Student s : students){
            if(s.getId().equals(id)){
                student = s; break;
            }
        }
        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).entity("not Found").build();
        }
        return Response.ok(student, MediaType.APPLICATION_XML).build();
    }

    @GET
    @Path("getstudentjson/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getStudentJsonFromIdPath(@PathParam("id") String id) {
        if((id == null) || (id.length() == 0)){
            return Response.serverError().entity("Cannot Be Empty").build();
        }
        Student student = null;
        for(Student s : students){
            if(s.getId().equals(id)){
                student = s; break;
            }
        }
        if(student == null){
            return Response.status(Response.Status.NOT_FOUND).entity("not Found").build();
        }
        return Response.ok(student, MediaType.APPLICATION_JSON).build();
    }


    @POST
    @Path("postf")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postWithForm(
            @FormParam("name") String name,
            @FormParam("age") String age){
        return "[POST] Name is : " + name + " And Age is : " + age;
    }


    @POST
    @Path("postf_mvmap")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postWithFormMvMap(MultivaluedMap<String, String> form){
        StringBuilder sb = new StringBuilder();
        sb.append("[POST] :: ");
        for(String key : form.keySet()){
            System.out.println(key + ":" + form.getFirst(key));
            sb.append("[" + key + ":" + form.getFirst(key) + "]");
        }
        return sb.toString();
    }

    @PUT
    @Path("putf_mvmap")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String putWithFormMvMap(MultivaluedMap<String, String> form){
        StringBuilder sb = new StringBuilder();
        sb.append("[PUT] :: ");
        for(String key : form.keySet()){
            System.out.println(key + ":" + form.getFirst(key));
            sb.append("[" + key + ":" + form.getFirst(key) + "]");
        }
        return sb.toString();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String deleteStudent(@PathParam("id") String id){
        for(Student s : students){
            if(s.getId().equals(id)){
                students.remove(s); break;
            }
        }
//            Entity.entity(students, MediaType.APPLICATION_XML);
//            Response r = Response.ok(Entity.entity(students, MediaType.APPLICATION_XML), MediaType.APPLICATION_XML).build();
        return "" + students.size();
    }

    public static Response getInternalSerErrResp(String msg){
        return Response.serverError().entity(msg).build();
    }

    public static Response getnotFoundErrResp(String msg){
        return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
    }

}