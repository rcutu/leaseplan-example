@smoke
Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

  Scenario Outline: User calls the endpoint for all the available products and receives the expected response
    Given user makes a GET request for the product '<PRODUCT>'
    Then the response status code is 200
    And the response body contains <NUMBER_OF_PRODUCTS>

    Examples:
      | PRODUCT | NUMBER_OF_PRODUCTS |
      | orange  | 0                  |
      | apple   | 9                  |
      | pasta   | 20                 |
      | cola    | 20                 |

  Scenario Outline: User calls the endpoint for an unavailable product
    Given user makes a GET request for the product '<UNAVAILABLE_PRODUCT>'
    Then the response status code is 404
    And the response body for '<UNAVAILABLE_PRODUCT>' contains an error

    Examples:
      | UNAVAILABLE_PRODUCT |
      | car                 |
      | mango               |