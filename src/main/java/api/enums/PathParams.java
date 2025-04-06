package api.enums;

import lombok.Getter;

@Getter
public enum PathParams {

    ORDER_ID("orderId");

    PathParams(String pathParam) {
        this.pathParam = pathParam;
    }

    private final String pathParam;
}
