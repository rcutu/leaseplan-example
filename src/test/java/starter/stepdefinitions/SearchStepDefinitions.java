package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.services.DrinksProductsClient;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.contains;

public class SearchStepDefinitions {

    @Steps
    public CarsAPI carsAPI;
    @Steps
    public DrinksProductsClient drinksProductsService;


    @When("user makes a GET request for the product {string}")
    public void userMakesAGetRequestForTheProduct(String product) {
        String endpoint = String.format("https://waarkoop-server.herokuapp.com/api/v1/search/demo/%s", product);
        SerenityRest.given().get(endpoint);
    }

    @Then("the response status code is {int}")
    public void responseStatusCodeIs(Integer responseStatusCode) {
        restAssuredThat(response -> response.statusCode(responseStatusCode));
    }

    @Then("the response body title contains {string}")
    public void responseBodyContain(String product) {
        restAssuredThat(response -> response.body("title", contains(product)));
    }

    @Then("the response body contains an error")
    public void responseBodyContainsError() {
        restAssuredThat(response -> response.body("error", contains("True")));
    }
}
