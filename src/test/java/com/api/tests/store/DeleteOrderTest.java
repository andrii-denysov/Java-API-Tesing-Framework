package com.api.tests.store;

import api.annotations.Negative;
import api.entities.Order;
import com.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static api.constants.Constants.NOT_EXISTED_ORDER_ID;
import static api.enums.ErrorMessages.ORDER_NOT_FOUND;
import static api.enums.JsonSchemas.ERROR_RESPONSE;
import static api.enums.PathParams.ORDER_ID;
import static api.enums.Routes.STORE_ORDER_ID;
import static api.helpers.RequestHelper.createDefaultOrder;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class DeleteOrderTest extends BaseTest {

    @Test
    public void testDeleteExistedOrder() {
        Order newlyCreatedOrder = createDefaultOrder();
        given(requestSpecification)
                .pathParam(ORDER_ID.getPathParam(), newlyCreatedOrder.getId())
                .delete(STORE_ORDER_ID.getEndpoint())
                .then()
                .spec(responseSpecification);
        given(requestSpecification)
                .pathParam(ORDER_ID.getPathParam(), newlyCreatedOrder.getId())
                .get(STORE_ORDER_ID.getEndpoint())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(matchesJsonSchemaInClasspath(ERROR_RESPONSE.getPath()))
                .body("message", equalTo(ORDER_NOT_FOUND.getErrorMessage()));
    }

    @Test(groups = {"negative"})
    @Negative
    public void testDeleteNotExistedOrder() {
        given(requestSpecification)
                .pathParam(ORDER_ID.getPathParam(), NOT_EXISTED_ORDER_ID)
                .delete(STORE_ORDER_ID.getEndpoint())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .body(matchesJsonSchemaInClasspath(ERROR_RESPONSE.getPath()))
                .body("message", equalToIgnoringCase(ORDER_NOT_FOUND.getErrorMessage()));
    }
}
