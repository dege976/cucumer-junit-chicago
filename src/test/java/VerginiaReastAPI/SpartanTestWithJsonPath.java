package VerginiaReastAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;


public class SpartanTestWithJsonPath {

    @Test
    public void verify(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",11)
                .when().get("/spartans/{id}");
        assertEquals(200,response.statusCode());
        assertEquals("application/json;charset=UFT-8",response.contentType());

        ////Store response json body/payload into JSONPATH object
        JsonPath json = response.jsonPath();

        ////// This way is good when you have a file
       // JsonPath jsonPath = new JsonPath(response.body().asString());

       int id = json.getInt("id");
       String name = json.getString("name");
       String gender = json.getString("gender");
       Long phone = json.getLong("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        assertEquals(11,id);
        assertEquals("Nona",name);
        assertEquals("bcgasdg",gender);
      //  assertEquals(73949379l,phone);
    }

    @Test
    public void getStudentsJsonPath(){
        JsonPath json = get("http://api.cybertektraining.com/student/all").jsonPath();
        //jsonPath.prettyPrint();
        List<String> countryName = json.getList( "students.contact.contactId");
        System.out.println("countryName = " + countryName);

        List<String> country = json.getList("students.contact.contactId");
        List<String> a = json.getList("students.findAll {it.batch == 10}.studentId");
        System.out.println("a = " + a);




    }


}
