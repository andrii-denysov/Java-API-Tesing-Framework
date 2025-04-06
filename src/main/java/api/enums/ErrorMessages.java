package api.enums;

public enum ErrorMessages {

    ORDER_NOT_FOUND("Order not found");

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private final String errorMessage;
}
