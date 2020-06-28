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

public class SpartanTestWithParameters {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = Config.getProperty("baseURL");

        //set up URI so that we don't have to type this everytime
    }

    @Test
    public void a(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/teacher/3301");
        System.out.println(response.getHeader("id").toString());
       // System.out.println(response.body().path());
        response.getBody().asString().endsWith("e");
    }
    /*
    {
    "teachers": [
        {
            "teacherId": 3301,
            "firstName": "James",
            "lastName": "Bond",
            "emailAddress": "James@gmail.com",
            "joinDate": "01/03/2020",
            "password": "12345",
            "phone": "7739764523",
            "subject": "Java",
            "gender": "Male",
            "department": "Science",
            "birthDate": "01/01/1978",
            "salary": 100000,
            "batch": 10,
            "section": "Empty",
            "premanentAddress": "100 main street"
        },
     */

    @Test
    public void countries(){
        RestAssured.baseURI = Config.getProperty("baseURL");
        Response response = get("kjdsdj");
        String firstCountryId = response.path("item.country_id[0]");
        String first = response.path("item.country_name[0]");
        System.out.println("firstCountryId = " + firstCountryId);
        System.out.println("first = " + first);
        List<String> a = response.path("items.country_name");
        System.out.println(a);
        //assetrt that all region id equals to 2
        List<Integer> integers = response.path("items.region_id");
        for (int integer : integers) {
            assertEquals(2,integer);
        }




    }
}
