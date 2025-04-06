package com.api.tests.store;

import api.annotations.Negative;
import api.entities.Order;
import com.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static api.enums.PathParams.ORDER_ID;
import static api.enums.Routes.STORE_ORDER;
import static api.helpers.EntityGenerator.createDefaultOrderObject;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlaceOrderTest extends BaseTest {

    @Test(groups = {"orderCleanUp"})
    public void testPlaceAValidOrder(ITestContext context) {
        Order expectedOrder = createDefaultOrderObject();
        Order actualOrder = given(requestSpecification)
                .body(expectedOrder)
                .post(STORE_ORDER.getEndpoint())
                .then()
                .spec(responseSpecification)
                .extract().response().as(Order.class);
        context.setAttribute(ORDER_ID.getPathParam(), actualOrder.getId());
        assertThat(actualOrder).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedOrder);
    }

    @Test(groups = {"negative"})
    @Negative
    public void testPlaceAnOrderWithExistedOrderId() {
        Order expectedOrder = createDefaultOrderObject();
        Order actualOrder = given(requestSpecification)
                .body(expectedOrder)
                .post(STORE_ORDER.getEndpoint())
                .then()
                .spec(responseSpecification)
                .extract().response().as(Order.class);
        given(requestSpecification)
                .body(actualOrder)
                .post(STORE_ORDER.getEndpoint())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(groups = {"negative"})
    @Negative
    public void testNegativePlaceEmptyOrder() {
        given(requestSpecification)
                .post(STORE_ORDER.getEndpoint())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
