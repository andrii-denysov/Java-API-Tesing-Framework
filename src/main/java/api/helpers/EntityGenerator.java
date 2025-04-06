package api.helpers;

import api.entities.Order;
import api.entities.Status;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

import static api.helpers.Utils.getCurrentTime;

@Slf4j
public final class EntityGenerator {

    public static Order createDefaultOrderObject() {
        Order order = new Order(new BigInteger("0"), 0, 1, getCurrentTime(), Status.PLACED, true);
        log.debug("Order object has been created: {}", order);
        return order;
    }
}
