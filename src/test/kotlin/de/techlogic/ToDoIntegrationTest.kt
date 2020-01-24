package de.techlogic

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.greaterThan
import org.junit.jupiter.api.Test
import javax.transaction.Transactional

@QuarkusTest
open class ToDoIntegrationTest(): DatabaseTest() {



    @Test
    fun canAddNewToDo() {
        RestAssured.given()
                .`when`().body("Test")
                .post("/todo")
                .then()
                .statusCode(200).and().body("id",greaterThan(0),"text", equalTo("Test"))
    }

    @Test
    fun canGetToDo(){   
       val todo = prepareTestData()
        RestAssured.given().`when`().get("/todo/"+todo.id)
                .then().statusCode(200).and().body("id", equalTo(todo.id.toInt()),"text", equalTo(todo.text))
    }

    @Transactional
    fun prepareTestData():ToDoEntry {
        val todo = ToDoEntry("Test")
        todo.persistAndFlush()

        return todo
    }

}