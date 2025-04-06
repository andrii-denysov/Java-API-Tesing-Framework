package api.helpers;

import api.entities.Order;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

import static api.enums.PathParams.ORDER_ID;
import static api.enums.Routes.STORE_ORDER;
import static api.enums.Routes.STORE_ORDER_ID;
import static api.helpers.EntityGenerator.createDefaultOrderObject;
import static api.helpers.Utils.buildRequestSpecification;
import static api.helpers.Utils.buildResponseSpecification;
import static io.restassured.RestAssured.*;

@Slf4j
public final class RequestHelper {

    public static Order createDefaultOrder() {
        Order expectedOrder = createDefaultOrderObject();
        log.debug("Creating default order: {}", expectedOrder);
        return given(buildRequestSpecification())
                .body(expectedOrder)
                .post(STORE_ORDER.getEndpoint())
                .then()
                .spec(buildResponseSpecification())
                .extract().response().as(Order.class);
    }

    public static void deleteOrder(BigInteger orderId) {
        log.debug("Deleting order with: '{}' order id", orderId);
        given(buildRequestSpecification())
                .pathParam(ORDER_ID.getPathParam(), orderId)
                .get(STORE_ORDER_ID.getEndpoint())
                .then()
                .assertThat()
                .spec(buildResponseSpecification());
    }
}
