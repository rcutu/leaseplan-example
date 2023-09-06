package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import starter.context.DataKeys;
import starter.context.ScenarioContext;
import starter.services.DrinksProductsClient;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    @Steps
    public DrinksProductsClient drinksProductsClient;
    @Steps
    public ScenarioContext scenarioContext;


    @When("user makes a GET request for the product {string}")
    public void userMakesAGetRequestForTheProduct(String product) {
        Response response = drinksProductsClient.getProducts(product);

//        initially I was thinking that I am going to need the context for response (never used serenity before)
        scenarioContext.save(DataKeys.RESPONSE, response);
    }

    @Then("the response status code is {int}")
    public void responseStatusCodeIs(Integer responseStatusCode) {
        restAssuredThat(response -> response.statusCode(responseStatusCode));
    }

    @Then("the response body contains {int} products")
    public void responseBodyContain(Integer numberOfProducts) {

        if(numberOfProducts != 0) {
            assertThat(SerenityRest.then().extract().jsonPath().getList("$")).isNotEmpty();
            assertThat(SerenityRest.then().extract().jsonPath().getList("$").size()).isEqualTo(numberOfProducts);
        } else {
            assertThat(SerenityRest.then().extract().jsonPath().getList("$")).isEmpty();
        }
    }

    @Then("the response body for {string} contains an error")
    public void responseBodyContainsError(String requestedItem) {
        JsonPath path = SerenityRest.then().extract().jsonPath();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(path.getBoolean("detail.error")).isEqualTo(true);
        softAssertions.assertThat(path.getString("detail.message")).isEqualTo("Not found");
        softAssertions.assertThat(path.getString("detail.requested_item")).isEqualTo(requestedItem);
        softAssertions.assertAll();
    }
}
