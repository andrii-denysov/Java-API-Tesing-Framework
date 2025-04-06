package api.helpers;

import api.helpers.serializers.OffsetDateTimeSerializer;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import static api.constants.Constants.BASE_URI;

@Slf4j
public final class Utils {

    public static OffsetDateTime getCurrentTime() {
        OffsetDateTime currentTime = Instant.now().truncatedTo(ChronoUnit.MILLIS).atOffset(ZoneOffset.UTC);
        log.debug("Offset date time object has been created: {}", currentTime);
        return currentTime;
    }

    public static RequestSpecification buildRequestSpecification() {
        log.debug("Setting base uri to '{}'", BASE_URI);
        return RestAssured.given()
//                Debug option
//                .log().all()
                .baseUri(BASE_URI)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    public static ResponseSpecification buildResponseSpecification() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(HttpStatus.SC_OK);
        builder.expectContentType(ContentType.JSON);
        return builder.build();
    }
}
