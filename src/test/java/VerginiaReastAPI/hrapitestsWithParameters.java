package VerginiaReastAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.Config;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class hrapitestsWithParameters {
    @BeforeClass
    public static void setup(){
        //set base uri that is defined in properties file
        baseURI = Config.getProperty("cybertekTrainingURL");

    }
    /*
    given accept type is json and paramer\ters
     */
    @Test
    public void get(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q","{\"region\":2}")
                .when().get("/countries");
        response.prettyPrint();
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains(""));


    }


}
