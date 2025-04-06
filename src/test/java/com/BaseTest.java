package com;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.ITestContext;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeSuite;

import java.math.BigInteger;

import static api.enums.PathParams.ORDER_ID;
import static api.helpers.RequestHelper.deleteOrder;
import static api.helpers.Utils.buildRequestSpecification;
import static api.helpers.Utils.buildResponseSpecification;

public abstract class BaseTest {

    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;

    @BeforeSuite
    protected void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = buildRequestSpecification();
        responseSpecification = buildResponseSpecification();
    }

    @AfterGroups("orderCleanUp")
    protected void orderCleanUp(ITestContext testContext) {
        BigInteger orderId = (BigInteger) testContext.getAttribute(ORDER_ID.getPathParam());
        deleteOrder(orderId);
    }
}
