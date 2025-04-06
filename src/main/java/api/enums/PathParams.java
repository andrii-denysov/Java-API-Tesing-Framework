package api.enums;

public enum PathParams {

    ORDER_ID("orderId");

    PathParams(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getPathParam() {
        return pathParam;
    }

    private final String pathParam;
}
