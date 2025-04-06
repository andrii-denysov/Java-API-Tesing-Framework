package api.enums;

public enum JsonSchemas {

    STORE_INVENTORY("jsonSchemas/inventory-schema.json"),
    ERROR_RESPONSE("jsonSchemas/error-response-schema.json");

    JsonSchemas(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    private final String path;
}
