# Spring Boot RESTful Web Service For Credit Card Validation

It supports credit card validations for AMEX, Discover, MasterCard, and Visa.

## Platform requirements

1. OpenJDK 11
2. Apache Maven 3.6

## How to build
Execute the following steps:
```
$ git clone https://github.com/carlouni/credit-card-service.git
$ cd credit-card-service
$ mvn clean package
```

## How to run
Execute the command below and wait until Tomcat server is up and running on port 8080
```
$ java -jar target/credit-card-service-0.0.1-SNAPSHOT.jar
```
Once the server is up, execute the command below with the any card number

### Test from command line using curl
```
$ curl --location --request POST 'localhost:8080/api/credit-card/validate' --header 'Content-Type: application/json' --data-raw '{ "cardNumber": "4111111111111111" }'
```
Example output:
```JSON
{"cardNumber":"4111111111111111","vendor":"VISA","status":"valid"}
```

### Test using Swagger
1. Open a web browser and go to http://localhost:8080/swagger-ui.html
2. Pick up the endpoint <b>POST /api/credit-card/validate</b>
3. Click on <b>"Try it out"</b> button.
4. Edit the JSON request body with a credit card number. See example below

```JSON
{
  "cardNumber": "4111 1111 1111 1111"
}
```
Example output:
```JSON
{
  "cardNumber": "4111 1111 1111 1111",
  "vendor": "VISA",
  "status": "valid"
}
```

### Running automated tests
Run automated tests by executing
```
$ mvn test
```

#### CreditCardControllerTest
Makes a series of HTTP calls with test cases defined in **src/test/resources/creditcards.json**
```
src/test/java/com/gccm/creditcard/controller/CreditCardControllerTest.java
```

#### Validation Strategy tests
Used for testing vendors validation and the Luhn validation algorithm
```
src/test/java/com/gccm/creditcard/strategy/LuhnStrategyTest.java
src/test/java/com/gccm/creditcard/strategy/DiscoverStrategyTest.java
src/test/java/com/gccm/creditcard/strategy/AmexStrategyTest.java
src/test/java/com/gccm/creditcard/strategy/VisaStrategyTest.java
src/test/java/com/gccm/creditcard/strategy/MasterCardStrategyTest.java
```