package PetStoreAuto.Tests;

import PetStoreAuto.Endpoints.UserEndpoints;
import PetStoreAuto.Payload.User;
import PetStoreAuto.Utlities.DDP;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DDP.class)
    public void testPostUser(String UserId, String UserName, String FirstName, String LastName, String Email, String Password, String Phone) {
       User userPayload = new User();
       userPayload.setId(Integer.parseInt(UserId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);

        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DDP.class)
    public void testDeleteUserByName(String UserName) {
        Response response = UserEndpoints.deleteUserByName(UserName);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
