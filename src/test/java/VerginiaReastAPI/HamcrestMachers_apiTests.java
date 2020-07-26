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
import static org.hamcrest.Matchers.*;

import org.junit.BeforeClass;


public class HamcrestMachers_apiTests {

    @Test
    public void asserthamcrest(){

        /*
        dents": [
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
         */
        given().accept(ContentType.JSON)
                .and().pathParam("id",8281)
                .when().get("http://api.cybertektraining.com/student/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json;charset=UTF-8")
                .and().assertThat().body("id",equalTo(8281),
                "firstName",equalTo("Phyliss"),"gender",equalTo("Male"));

    }
}
