package com.myProject.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APIStepDefs {

    private static final Log log = LogFactory.getLog(APIStepDefs.class);
    //Response response;
    JsonPath jsonPath;
    public HashMap<Object,Object> map=new HashMap<Object,Object>();

    @Given("^the valid endpoint to fetch users$")
    public void setupEndpoint()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users";
    }

    @When("^the request is send to server with page number as (.*)$")
    public void sendRequest(int pageNumber)
    {
        jsonPath = given().
                queryParam("page",pageNumber).
                when().
                get().
                then().
                log().ifValidationFails().statusCode(HttpStatus.SC_OK).extract().response().jsonPath();
    }


    @Then("^validate the response of first user record having email as (.*)$")
    public void validateUserData(String emailID)
    {
        String userEmail =jsonPath.getString("data[0].email");
        Assert.assertEquals(userEmail, emailID);
    }

    @Given("^the valid endpoint with payload to create user$")
    public void setupEndpointAndPostData()
    {
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users";
        map.put("name","john");
        map.put("job", "Software Developer");
    }

    @When("^the request is send to the server$")
    public void sendRequest()
    {
        jsonPath = given()
                .contentType(ContentType.JSON).log().all()
                .body(map)
                .when()
                .post()
                .then()
                .log().all().statusCode(HttpStatus.SC_CREATED).extract().response().jsonPath();
    }

    @Then("^the new user must be created with name as (.*)$")
    public void validateResponse(String name)
    {
        String userName = jsonPath.getString("name");
        Assert.assertEquals(userName, name);
    }
}
