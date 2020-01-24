package de.techlogic

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.Rule
import org.junit.jupiter.api.Test

@QuarkusTest
open class ExampleResourceTest: DatabaseTest() {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello")
          .then()
             .statusCode(200)
    }

    fun test(){

    }

}