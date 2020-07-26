package VerginiaReastAPI.Day6restAPI_json_serialization;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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

public class JsonToCollection {
    @Test
    public void javaObject(){
        Response response = given().accept(ContentType.JSON)
        .get("http://api.cybertektraining.com/s/8281");

        /*
        {
    "students": [
        {
            "studentId": 8281,
            "firstName": "Phyliss",
            "lastName": "Edelstein",
            "batch": 10,
            "joinDate": "01/01/2010",
            "birthDate": "01/01/1990",
            "password": "123",
            "subject": "Linear Algebra",
            "gender": "Male",
            "admissionNo": "10",
            "major": "Calculus",
            "section": "LaLigA",
            "contact": {
                "contactId": 8281,
                "phone": "2061166182",
                "emailAddress": "koteague0@shutterfly.com",
                "premanentAddress": "965 Nancy Center, Long Beach, CA 90847"
            },
         */
        Map<String,?> employeeMap = response.body().as(Map.class);
        System.out.println(employeeMap.toString());

        String firstName =  employeeMap.get("firstName").toString();
        System.out.println("firstName = " + firstName);
        assertEquals("Phyliss",firstName);

        double salary=  (Double)employeeMap.get("salary");
        System.out.println("salary = " + salary);

        assertEquals(4800,salary,1);

        //delta amount . if there difference by delta amount or less.
        // values will be considered equal
    }

    @Test
    public void convertToListOfMap(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/studens/all");
        List<Map<String,Object>> jsonListOfMap = response.body().as(List.class);
        //print all data of first student

        System.out.println(jsonListOfMap.get(0));

        Map<String,?> first = jsonListOfMap.get(0);
        System.out.println("first = " + first);

        int count  = 1;
        for (Map<String,?> student:jsonListOfMap){
            System.out.println(count + " -student = " + student);
            count++;
        }

    }

    @Test
    public void dataCollections(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/studens/8281");
        Map<String, ?> dataMap = response.as(Map.class);
        System.out.println(dataMap.toString());






























    }
}
