package VerginiaReastAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
public class VSpartanTestWithParameters {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }
    @Test
    public void helloTest(){
        //response
       Response response =  get("/teacher/3021");



       //response
       //verify status code 200
        assertEquals(200,response.statusCode());
        //verify header
        assertEquals("application/json;charset=UTF-8",response.contentType());
        System.out.println(response.getHeader("Date"));
        assertTrue(response.headers().hasHeaderWithName("Date"));
        System.out.println("Status code " + response.statusLine());
        //verifying content type
        System.out.println("Content type " + response.contentType());
        System.out.println(response.getHeader("Server"));
        System.out.println("Response body/pay load " + response.body().asString());

    }

    @Test
    public void parTest(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id","3021")
                .when().get("/teacher/{id}");
       // .then().log().all();
       // response.prettyPrint();

       // assertEquals("200",response.statusCode());
        assertEquals("application/json;charset=UTF-8",response.contentType());
        assertTrue(response.body().asString().contains("abcd"));
    }

    @Test
    public void a(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id","3021")
                .when().get("/teacher/{id}");
        //response validtions
        assertEquals(404,response.statusCode());
        assertEquals("application/json;charset=UTF-8",response.contentType());
        assertTrue(response.body().asString().contains("not found"));
    }

    @Test
    public void as(){
       Response response = given().accept(ContentType.JSON)
                           .queryParam("gender","Female")
                           .queryParam("nameContains","e")
                           .when().get("/spartans/search");
       Response response2 = given().accept(ContentType.JSON)
                            .when().get("/spartans/search?gender=female&nameContains=e");
       assertEquals(200,response2.statusCode());
       assertEquals("application/json;charset=UTF-8",response2.contentType());
       assertTrue(response2.body().asString().contains("Female"));

        Response response3 = given().accept(ContentType.JSON)
                .queryParam("gender","Female","nameContains","e")
                .when().get("/spartans/search");

    }

    @Test
    public void invalid(){
        Response response1 = given().accept(ContentType.XML)
                            .queryParams("gender","Female","nameContains","e")
                            .when().get("spartans/search");
        Response response12 = given().accept(ContentType.XML)
                            .queryParams("gender","Female")
                            .queryParam( "nameContains","e")
                            .when().get("spartans/search");

        Map<String,Object> pa = new HashMap<>();
        pa.put("gender","Female");
        pa.put("nameContains","e");

        Response response = given().accept(ContentType.XML)
                .queryParams(pa)
                .when().get("http//:api/spartans/search");

        //response validation with junit Assertions
        assertEquals(406,response.statusCode());

        assertTrue(response.body().asString().contains("hbkbkg9tijkdabcdgiysifk;zhckh"));
    }
}
