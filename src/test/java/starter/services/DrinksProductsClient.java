package starter.services;

import net.serenitybdd.rest.SerenityRest;

public class DrinksProductsClient {

    private String demoUrl = "https://waarkoop-server.herokuapp.com/api/v1/search/demo/";


    public void getProducts() {
        SerenityRest.given().get(demoUrl);
    }
}
