package api.enums;

import lombok.Getter;

@Getter
public enum JsonSchemas {

    STORE_INVENTORY("jsonSchemas/inventory-schema.json"),
    ERROR_RESPONSE("jsonSchemas/error-response-schema.json");

    JsonSchemas(String path) {
        this.path = path;
    }

    private final String path;
}
