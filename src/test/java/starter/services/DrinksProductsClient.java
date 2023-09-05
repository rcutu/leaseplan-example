package starter.services;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class DrinksProductsClient {

    private final String demoUrl = "https://waarkoop-server.herokuapp.com/api/v1/search/demo/";


    public Response getProducts(String endpoint) {
        return SerenityRest.given().get(demoUrl + endpoint);
    }
}
