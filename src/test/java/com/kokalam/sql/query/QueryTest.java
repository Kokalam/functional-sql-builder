package com.kokalam.sql.query;

import com.kokalam.sql.query.instructions.select.column.Column;
import com.kokalam.sql.query.instructions.from.clauses.table.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueryTest {

    @Test
    @DisplayName("select all column from table User")
    public void shouldReturnQueryWithAllColumnFromTableUser() {
        final String expectedQuery = "SELECT * FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                    s.column(c -> c.name("*"))
                ).from(f ->
                    f.table(t -> t.name("User"))
                ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name from table User")
    public void shouldReturnQueryWithOneColumnFromTableUser() {
        final String expectedQuery = "SELECT name FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name"))
            )
            .from(f ->
                f.table(t -> t.name("User"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name and surname from table User")
    public void shouldReturnQueryWithTwoColumnFromTableUser() {
        final String expectedQuery = "SELECT name,surname FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name"))
                 .column(c -> c.name("surname"))
            ).from(f ->
                f.table(t -> t.name("User"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name as pseudo from table User")
    public void shouldReturnQueryWithOneColumnAsFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name").as("pseudo"))
            ).from(f ->
                f.table(t -> t.name("User"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name as pseudo and surname from table User")
    public void shouldReturnQueryWithOneColumnAsAndOneColumnFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo,surname FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name").as("pseudo"))
                 .column(c -> c.name("surname"))
            ).from(f ->
                f.table(t -> t.name("User"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name as pseudo and surname as family_name from table User")
    public void shouldReturnQueryWithTwoColumnAsFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo,surname as family_name  FROM User";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name").as("pseudo"))
                 .column(c -> c.name("surname").as("family_name"))
            ).from(f ->
                f.table(t -> t.name("User"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name from table User as u and column street from table Address as a")
    public void shouldReturnQueryWithTwoColumnAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name,a.street FROM User u,Address a";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.of("u").name("name"))
                 .column(c -> c.of("u").name("street"))
            ).from(f ->
                f.table(t -> t.name("User").as("u"))
                 .table(t -> t.name("Address").as("a"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name from table User and column street from table Address")
    public void shouldReturnQueryWithTwoColumnAsFromTwoTable() {
        final String expectedQuery = "SELECT User.name,Address.street FROM User,Address";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.of("User").name("name"))
                 .column(c -> c.of("Address").name("street"))
            ).from(f ->
                f.table(t -> t.name("User"))
                 .table(t -> t.name("Address"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name as pseudo from table User and column street as location from table Address")
    public void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTable() {
        final String expectedQuery = "SELECT name as pseudo,street as location FROM User,Address";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.name("name").as("pseudo"))
                 .column(c -> c.name("street").as("location"))
            ).from(f ->
                f.table(t -> t.name("User"))
                 .table(t -> t.name("Address"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("should select column name as pseudo from table User as u and column street as location from table Address as a")
    public void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name as pseudo,a.street as location FROM User,Address";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.of("u").name("name").as("pseudo"))
                 .column(c -> c.of("a").name("street").as("location"))
            ).from(f ->
                f.table(t -> t.name("User").as("u"))
                 .table(t -> t.name("Address").as("a"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("call from clause before select clause")
    public void shouldThrowIllegalStateExceptionWhenFromIsCalledBeforeSelect() {
        Query.Builder builder = new Query.Builder();
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from(f ->
                f.table(t -> t.name("User").as("u"))
        ));
    }
}
