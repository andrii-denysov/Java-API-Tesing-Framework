package com.api.tests.store;

import api.enums.JsonSchemas;
import com.BaseTest;
import org.testng.annotations.Test;

import static api.enums.Routes.STORE_INVENTORY;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class InventoryTest extends BaseTest {

    /*
    This test is verifying "/store/inventory" endpoint, I haven't found any other endpoints that allows us to create,
    update or delete entities in response, but according to swagger documentation should return only 3 entities with
    a number: "sold", "available" and "pending", so the only thing that we can check here that endpoint is returning us
    these values and that they are integers. It's also possible to add one more test with following logic: get inventory
    and store the response -> create new order -> get inventory one more time and check that number of "pending" states
    has increased by 1, unfortunately it's not possible in current circumstances as value is constantly changing cause
    someone is also accessing this endpoint or any other that hasn't been specified in the swagger.
     */
    @Test
    public void testGetInventory() {
        given(requestSpecification)
                .get(STORE_INVENTORY.getEndpoint())
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body(matchesJsonSchemaInClasspath(JsonSchemas.STORE_INVENTORY.getPath()));
    }
}
