package VerginiaReastAPI.Day6restAPI_json_serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Spartan {
    public Spartan(   Integer studentId, String firstName, String lastName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Integer id;
    String name;
    String gender;
    Long phone;

//    "studentId": 8281,
//            "firstName": "Phyliss",
//            "lastName": "Edelstein",
    Integer studentId;
    String firstName;
    String lastName;

    //Computer
    //Teacher ID:
    //3532
    //Phone:
    //773444555
    //Email:
    //jwick7@gmail.com
    //Batch:
    //1


}
