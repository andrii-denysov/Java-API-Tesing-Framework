package api.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum Status {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static Status fromStatus(String status) {
        for (Status statusEnum : Status.values()) {
            if (Objects.equals(statusEnum.status, status)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + status + "]");
    }
}
