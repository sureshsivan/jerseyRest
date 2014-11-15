package com.suren.learn;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import java.util.HashMap;
import java.util.Map;

public class ResourceTest extends JerseyTestNg.ContainerPerClassTest{


//            private static ResourceTest self = null;
//
//    public ResourceTest() {
//        super();
//    }
//
//    @Override
//    @BeforeClass
//    public void setUp() throws Exception {
//            System.out.println("Before^^^^^^");
//            super.setUp();
//    }
//
//    @Override
//    @AfterClass
//    public void tearDown() throws Exception {
//            System.out.println("After^^^^^^");
//            super.tearDown();
//    }
//
//    public void stopContainer() throws Exception {
//            super.tearDown();
//    }
//
////    @AfterClass
////    public static void stop() throws Exception {
////        System.out.println("After Class ^^^^^^");
////        self.stopContainer();
////    }

    @Override
    protected Application configure() {
        ResourceConfig rc = new ResourceConfig();
        rc.packages("com.suren.learn");
        rc.register(createMoxyJsonResolver());
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return rc;
    }

//    @org.testng.annotations.Test(priority = 1)
//    public void testGetText(){
//        Response resp = target("myresource").request().get();
//        org.junit.Assert.assertEquals(resp.readEntity(String.class), "Got it!");
//    }
//
//    @org.testng.annotations.Test(priority = 2)
//    public void testGetWithPathParam(){
//        Response resp1 = target("myresource/get/suresh").request().get();
//        Response resp2 = target("myresource/get/kirthi").request().get();
//        org.junit.Assert.assertEquals(resp1.readEntity(String.class), "suresh Is Great");
//        org.junit.Assert.assertEquals(resp2.readEntity(String.class), "kirthi Is Great");
//    }
//
//    @org.testng.annotations.Test(priority = 3)
//    public void testGetWithTwoQueryParam(){
//        Response resp1 = target("myresource/getq").
//                queryParam("name", "suren").
//                queryParam("age", "27").
//                request().get();
//        Response resp2 = target("myresource/getq").
//                queryParam("name", "kirthi").
//                queryParam("age", "26").
//                request().get();
//        org.junit.Assert.assertEquals(resp1.readEntity(String.class), "Name is : suren And Age is : 27");
//        org.junit.Assert.assertEquals(resp2.readEntity(String.class), "Name is : kirthi And Age is : 26");
//    }
//
//
//    @org.testng.annotations.Test(priority = 4)
//    public void testGetJsonObject(){
//        Response resp = target("myresource/getjson").
//                request().
//                accept(MediaType.APPLICATION_JSON_TYPE).
//                get();
//        Student responseStudent = resp.readEntity(Student.class);
//        org.junit.Assert.assertEquals(responseStudent.getFname(), "suren");
//        org.junit.Assert.assertEquals(responseStudent.getLname(), "siva");
//        org.junit.Assert.assertEquals(responseStudent.getId(), "1");
//        org.junit.Assert.assertEquals(responseStudent.getAge(), 27);
//    }
//
//    @org.testng.annotations.Test(priority = 5)
//    public void testGetXmlObject(){
//        Response resp = target("myresource/getxml").
//                request().
//                accept(MediaType.APPLICATION_XML_TYPE).
//                get();
//        Student responseStudent = resp.readEntity(Student.class);
//        org.junit.Assert.assertEquals(responseStudent.getFname(), "suren");
//        org.junit.Assert.assertEquals(responseStudent.getLname(), "siva");
//        org.junit.Assert.assertEquals(responseStudent.getId(), "1");
//        org.junit.Assert.assertEquals(responseStudent.getAge(), 27);
//    }
//
//    @org.testng.annotations.Test(priority = 6)
//    public void testGetJsonObjectList(){
//        Response resp = target("myresource/getjsonlist").
//                request().
//                accept(MediaType.APPLICATION_JSON_TYPE).
//                get();
//        List<Student> responseStudents = resp.readEntity(new GenericType<List<Student>>(){});
//        org.junit.Assert.assertEquals(responseStudents.size(), 3);
//    }
//
//    @org.testng.annotations.Test(priority = 7)
//    public void testGetXmlObjectList(){
//        Response resp = target("myresource/getxmllist").
//                request().
//                accept(MediaType.APPLICATION_XML_TYPE).
//                get();
//        List<Student> responseStudents = resp.readEntity(new GenericType<List<Student>>(){});
//        org.junit.Assert.assertEquals(responseStudents.size(), 3);
//    }
//
//    @org.testng.annotations.Test(priority = 8)
//    public void testPostWithForm(){
//        Form surenForm = new Form();
//        surenForm.param("name", "suren");
//        surenForm.param("age", "27");
//
//        Form kirthiForm = new Form();
//        kirthiForm.param("name", "kirthi");
//        kirthiForm.param("age", "26");
//
//        Response resp1 = target("myresource/postf").
//                request().post(Entity.form(surenForm));
//        Response resp2 = target("myresource/postf").
//                request().post(Entity.form(kirthiForm));
//
//        org.junit.Assert.assertEquals(resp1.readEntity(String.class), "[POST] Name is : suren And Age is : 27");
//        org.junit.Assert.assertEquals(resp2.readEntity(String.class), "[POST] Name is : kirthi And Age is : 26");
//
//    }
//
//    @org.testng.annotations.Test(priority = 9)
//    public void testPostWithFormMvMap(){
//        Form surenForm = new Form();
//        surenForm.param("name", "suren");
//        surenForm.param("age", "27");
//
//        Form kirthiForm = new Form();
//        kirthiForm.param("name", "kirthi");
//        kirthiForm.param("age", "26");
//
//        Response resp1 = target("myresource/postf_mvmap").
//                request().post(Entity.form(surenForm));
//        Response resp2 = target("myresource/postf_mvmap").
//                request().post(Entity.form(kirthiForm));
//
//        final String surenOutput = resp1.readEntity(String.class);
//        final String kirthiOutput = resp2.readEntity(String.class);
//
//        org.junit.Assert.assertNotNull(surenOutput);
//        org.junit.Assert.assertNotNull(kirthiOutput);
//
//        org.junit.Assert.assertTrue(surenOutput.startsWith("[POST]"));
//        org.junit.Assert.assertTrue(surenOutput.contains("suren"));
//        org.junit.Assert.assertTrue(surenOutput.contains("27"));
//        org.junit.Assert.assertTrue(surenOutput.endsWith("]"));
//
//
//        org.junit.Assert.assertTrue(kirthiOutput.startsWith("[POST]"));
//        org.junit.Assert.assertTrue(kirthiOutput.contains("kirthi"));
//        org.junit.Assert.assertTrue(kirthiOutput.contains("26"));
//        org.junit.Assert.assertTrue(kirthiOutput.endsWith("]"));
//
//    }
//
//
//    @org.testng.annotations.Test(priority = 10)
//    public void testPutWithFormMvMap(){
//        Form surenForm = new Form();
//        surenForm.param("name", "suren");
//        surenForm.param("age", "27");
//
//        Form kirthiForm = new Form();
//        kirthiForm.param("name", "kirthi");
//        kirthiForm.param("age", "26");
//
//        Response resp1 = target("myresource/putf_mvmap").
//                request().put(Entity.form(surenForm));
//        Response resp2 = target("myresource/putf_mvmap").
//                request().put(Entity.form(kirthiForm));
//
//        final String surenOutput = resp1.readEntity(String.class);
//        final String kirthiOutput = resp2.readEntity(String.class);
//
//        org.junit.Assert.assertNotNull(surenOutput);
//        org.junit.Assert.assertNotNull(kirthiOutput);
//
//
//        org.junit.Assert.assertTrue(surenOutput.startsWith("[PUT]"));
//        org.junit.Assert.assertTrue(surenOutput.contains("suren"));
//        org.junit.Assert.assertTrue(surenOutput.contains("27"));
//        org.junit.Assert.assertTrue(surenOutput.endsWith("]"));
//
//
//        org.junit.Assert.assertTrue(kirthiOutput.startsWith("[PUT]"));
//        org.junit.Assert.assertTrue(kirthiOutput.contains("kirthi"));
//        org.junit.Assert.assertTrue(kirthiOutput.contains("26"));
//        org.junit.Assert.assertTrue(kirthiOutput.endsWith("]"));
//
//    }
//
//    @org.testng.annotations.Test(priority = 11)
//    public void testDeleteStudent(){
//        Response resp = target("myresource/delete/1").
//                request().
//                accept(MediaType.TEXT_PLAIN).
//                delete();
////                            List<Student> responseStudents = resp.readEntity(new GenericType<List<Student>>(){});
////                            System.out.println(responseStudents);
//        Assert.assertEquals(resp.readEntity(String.class), "2");
////                            org.junit.Assert.assertEquals(resp.readEntity(String.class), "2");
//    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }

}