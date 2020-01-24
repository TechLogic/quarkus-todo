package de.techlogic;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;

public class DatabaseTest {

    @ClassRule
    private static PostgreSQLContainer postgreSQLContainer =
            new PostgreSQLContainer("postgres");

    @BeforeAll
    private static void setupPostgres() throws Exception {
        postgreSQLContainer.start();

        System.setProperty("quarkus.datasource.url",
                postgreSQLContainer.getJdbcUrl());
        System.setProperty("quarkus.datasource.username", "test");// (4)
        System.setProperty("quarkus.datasource.password", "test");
    }
}
