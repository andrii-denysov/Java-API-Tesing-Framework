package api.enums;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    ORDER_NOT_FOUND("Order not found");

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private final String errorMessage;
}
