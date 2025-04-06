package api.entities;

import api.helpers.deserializers.OffsetDateTimeDeserializer;
import api.helpers.serializers.OffsetDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Setter
@Getter
public class Order {

    @JsonCreator
    public Order(@JsonProperty("id") BigInteger id,
                 @JsonProperty("petId")Integer petId,
                 @JsonProperty("quantity") Integer quantity,
                 @JsonProperty("shipDate") OffsetDateTime shipDate,
                 @JsonProperty("status") Status status,
                 @JsonProperty("complete") boolean complete) {
        this.complete = complete;
        this.status = status;
        this.shipDate = shipDate;
        this.quantity = quantity;
        this.petId = petId;
        this.id = id;
    }

    private BigInteger id;
    private Integer petId;
    private Integer quantity;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime shipDate;
    private Status status;
    private boolean complete;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate=" + shipDate +
                ", status=" + status +
                ", complete=" + complete +
                '}';
    }
}
