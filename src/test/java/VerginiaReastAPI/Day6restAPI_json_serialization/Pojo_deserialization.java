package VerginiaReastAPI.Day6restAPI_json_serialization;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.jvm.hotspot.compiler.OopMapStream;
import utilities.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;


import org.junit.Test;

public class Pojo_deserialization {

    @Test
    public void pojoDeserialization(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/all");

        Spartan spartan = response.body().as(Spartan.class);
        System.out.println(spartan.getFirstName());
        assertEquals("gjhsgd",spartan.getFirstName());
        assertEquals(new Integer(335),spartan.studentId);

    }

    @Test
    public  void spar(){
        Gson gson = new Gson();
        Spartan spartan = new Spartan(20,"cgudsgcuys","jhdyg");
        //serialization  spartan object to json format using Gson
        String a = gson.toJson(spartan);
        System.out.println(a);

        String myjson = "{\"studentId\":20,\"firstName\":\"cgudsgcuys\",\"lastName\":\"jhdyg\"}\n";
        //Deserialization convert json to java spartan object
        Spartan z = gson.fromJson(myjson,Spartan.class);
        System.out.println(z);
    }
    @Test
    public void aaaa(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/all");

       // List<Spartan> all
    }
}
