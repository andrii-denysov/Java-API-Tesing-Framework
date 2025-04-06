# Java API Testing Framework for Swagger Petstore (Store Group)

[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen)](https://your-ci-cd-link.com) This project is a Java-based API testing framework specifically designed to test the **'store'** group endpoints of the [Swagger Petstore API](https://petstore.swagger.io/). It utilizes popular Java testing libraries such as **Rest-Assured** for making HTTP requests and **TestNG** for structuring and running tests. **SLF4J with Log4j 2** is used for logging test activities and results.

Developed by Andrii Denysov.

## Features

* **Targeted Testing:** Focuses exclusively on the 'store' group of the Swagger Petstore API.
* **Rest-Assured Integration:** Leverages the powerful features of Rest-Assured for concise and readable API interaction.
* **TestNG Framework:** Provides a robust framework for creating, organizing, and executing test cases.
* **Data-Driven Testing (Potential):** The framework can be easily extended to support data-driven testing for various scenarios.
* **Clear Assertions:** Uses Rest-Assured's built-in assertion capabilities and Hamcrest matchers to verify API responses.
* **Logging:** Implements SLF4J with Log4j 2 for comprehensive logging of requests, responses, and test execution flow.
* **Well-Structured:** Follows a logical project structure for maintainability and scalability.
* **Easy to Extend:** Designed to be easily extended with new test cases and functionalities for the 'store' API.

## 📦 What Is Tested?

The following endpoints from the `/store` group of Swagger Petstore are covered:

| HTTP Method | Endpoint                        | Description                   |
|-------------|----------------------------------|-------------------------------|
| `GET`       | `/store/inventory`              | Returns pet inventories by status |
| `POST`      | `/store/order`                  | Places an order for a pet     |
| `GET`       | `/store/order/{orderId}`        | Finds a purchase order by ID  |
| `DELETE`    | `/store/order/{orderId}`        | Deletes a purchase order      |


## Technologies Used

* **Java:** Programming language for the framework.
* **Rest-Assured:** Library for testing RESTful web services.
* **TestNG:** Testing framework for Java.
* **SLF4J:** Simple Logging Facade for Java.
* **Log4j 2:** Powerful and flexible logging framework.
* **Maven:** Build automation tool for managing dependencies and building the project.
* **Allure:** Test reporting framework.

## Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Make sure you have a compatible JDK installed on your system (e.g., Java 8 or higher).
* **Maven:** You need Maven installed to build and run the project. You can download it from the [official Apache Maven website](https://maven.apache.org/download.cgi).
* **Git:** To clone the repository.

### Cloning the Repository

```
git clone [https://github.com/andrii-denysov/Java-API-Tesing-Framework.git](https://github.com/andrii-denysov/Java-API-Tesing-Framework.git)
cd Java-API-Tesing-Framework
```

### Install Allure CLI using:
#### On MacOS
```
brew install allure
```

#### On Windows (via Scoop)
```
scoop install allure
```

## Run Tests

* Run with Maven:
```
mvn clean test
```

## Generate & Open Allure Report

```
allure serve target/allure-results
```
