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


public class JsonToJavaDataStructures {

    @Test
    public void convertData(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/all");
        Map<String,Object> spartans = response.as(Map.class);
        System.out.println("spartans = " + spartans.toString());
    }

}
