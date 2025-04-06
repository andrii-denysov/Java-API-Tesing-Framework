package api.enums;

public enum Routes {

    STORE_INVENTORY("/store/inventory"),
    STORE_ORDER("/store/order"),
    STORE_ORDER_ID("/store/order/{orderId}");

    Routes(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    private final String endpoint;
}
