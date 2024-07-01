package apiauto;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;


import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class testReqres {

    @Test
    public void testGetListUsers(){
        given()
                .when()
                .get( "https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(2))
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("total", Matchers.equalTo(12))
                .assertThat().body("total_pages", Matchers.equalTo(2))
                ;
    }

    @Test
    public  void testPostCreateUser() {

        String valueName = "Fadhli";
        String valueJob  = "Yuhuuu....";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        given()
                .header("Content-Type", "application/json")
                .header("Accept", "appliaction/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name",Matchers.equalTo(valueName))
                .assertThat().body("job",Matchers.equalTo(valueJob));


    }

    @Test
    public  void testPUTUser() {
//        define baseURI
        RestAssured.baseURI= "https://reqres.in/";
//        data to update

        int userId = 3;
        String newName = "YuhuhuHaha";
        String newEmail = "YuhuhuHaha@haha.ha";
        String newLname = "Cckckck";
        String newText = "UpdatePUTjayJAY-Yuhuuu...";
//        Test PUT user id 2 -> update first_name
//        first get the attribute of user id 2
        String fname = given().when().get( "api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("api/users/"+userId).getBody().jsonPath().get("data.email");
        String text = given().when().get("api/users/"+userId).getBody().jsonPath().get("support.text");
        System.out.println("name before= "+fname);

//        change the first name to "YuhuhuHaha"
//        create body request with map and convert it to json

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", newEmail);
        bodyMap.put("first_name", newName);
        bodyMap.put("lname", newLname);
        bodyMap.put("avatar", avatar);
        bodyMap.put("text", newText);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .put("api/users/"+ userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName))
                .assertThat().body("lname", Matchers.equalTo(newLname))
                .assertThat().body("email", Matchers.equalTo(newEmail))
                .assertThat().body("text", Matchers.equalTo(newText));
    }

    @Test
    public void testPatchUser(){
//        define baseURI
        RestAssured.baseURI = "https://reqres.in/";
//        data to update
        int userId = 4;
        String newName = "UpdateJayJay";
        String newemail = "UpdateJayJay@jay.up";

//        test patch user id 3 -> update first name
//        first, get the first name of user id 4
        String fname = given().when().get("api/users/"+userId)
                .getBody().jsonPath().get("data.first_name");
        System.out.println("name before= "+fname);
        String femail = given().when().get("api/users/"+userId)
                .getBody().jsonPath().get("data.email");
        System.out.println("email before= "+femail);


//        change the first name to "updateUser"
//        create body request with HashMap and convert it to json
        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        bodyMap.put("email", newemail);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given().log().all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("api/users/"+userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName))
                .assertThat().body("email", Matchers.equalTo(newemail));
    }

    @Test
    public void testDeleteUser(){
//        define baseURI
        RestAssured.baseURI="https://reqres.in";
//        data to delete
        int userToDelete = 4;
//        test delete api/users/4
        given().log().all()
                .when().delete("api/users/" +userToDelete)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }

    @Test
    public void testValidateJsonSchemaGetSingleUser(){
//        define baseURI
        RestAssured.baseURI = "https://reqres.in/";
//        data to get
        int userToGet = 5;
//        file Json Schema to compare
        File file =new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");
//        test get api/user/5
        given().log().all()
                .when().get("api/users/" + userToGet)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }

    @Test
    public void testValidateFAILJsonSchemaGetSingleUser(){
//        define baseURI
        RestAssured.baseURI = "https://reqres.in/";
//        data to get
        int userToGet = 5;
//        file Json Schema to compare
        File file =new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");
//        test get api/user/5
        given().log().all()
                .when().get("api/users/" + userToGet)
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
