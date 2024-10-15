package PetStoreAuto.Endpoints;

import PetStoreAuto.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class UserEndpoints {
    public static Response createUser(User Payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Payload)
                .when()
                .post(Routes.post);
        return response;

    }

    public static Response getUserByName(String username ){
        Response response =given()
                .pathParams("username",username)
                .when()
                .get(Routes.get);
        return response;
    }

    public static Response UpdateUserByName(String UserName,User userPayload){
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username",UserName)
                .body(userPayload)
                .when()
                .put(Routes.update);
        return response;
    }

    public static Response deleteUserByName(String username){
        Response response =given()
                .contentType(ContentType.JSON)
                .pathParams("username",username)
                .when()
                .delete(Routes.delete);
        return response;
    }
}
