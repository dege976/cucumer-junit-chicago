package VerginiaReastAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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

public class HRApiTestsPathVerification {
    @BeforeClass
    public static void setUp(){
        baseURI = Config.getProperty("baseURL");

    }

    @Test
    public void verifying(){
        Response response = given().accept("application/json")
                .and().pathParam("counttry_id","us")
                .when().get("/countries/{country_id}");

        int statuscode = response.statusCode();
        String country_id = response.path("country_id");
        String countryNmae = response.path("countr_id");
        int region = response.path("region_id");

        assertEquals(200,statuscode);
        assertEquals("us",country_id);
        assertEquals("united states",countryNmae);
        assertEquals(2,region);


    }

    @Test
    public void a(){
        Response response = given().accept("application/json")
                .and().queryParam("q","{\"department_id\":80}")
                .when().get("/employees");

        //validations
        assertEquals(200,response.statusCode());
        //extract values from json amd store into list, vars
        List<String> jobIds = response.path("items.job_id");
        List<Integer> depIds = response.path("items.department_id");
        int count = response.path("count");

        for (String jobId : jobIds){
            assertTrue(jobId.startsWith("SA"));
            assertEquals("SA",jobId.substring(0,2));
        }

        depIds.forEach(id->assertEquals(new Integer(80),id));

        assertEquals(25,count);



    }


}
