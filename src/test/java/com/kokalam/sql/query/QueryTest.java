package com.kokalam.sql.query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueryTest {

    @Test
    @DisplayName("select all column from table User")
    void shouldReturnQueryWithAllColumnFromTableUser() {
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
    void shouldReturnQueryWithOneColumnFromTableUser() {
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
    void shouldReturnQueryWithTwoColumnFromTableUser() {
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
    void shouldReturnQueryWithOneColumnAsFromTableUser() {
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
    void shouldReturnQueryWithOneColumnAsAndOneColumnFromTableUser() {
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
    void shouldReturnQueryWithTwoColumnAsFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo,surname as family_name FROM User";
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
    void shouldReturnQueryWithTwoColumnAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name,a.street FROM User u,Address a";
        Query.Builder builder = new Query.Builder();
        Query query = builder.select(s ->
                s.column(c -> c.of("u").name("name"))
                 .column(c -> c.of("a").name("street"))
            ).from(f ->
                f.table(t -> t.name("User").as("u"))
                 .table(t -> t.name("Address").as("a"))
            ).build();

        Assertions.assertEquals(expectedQuery, query.get());
    }

    @Test
    @DisplayName("select column name from table User and column street from table Address")
    void shouldReturnQueryWithTwoColumnAsFromTwoTable() {
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
    void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTable() {
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
    void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name as pseudo,a.street as location FROM User u,Address a";
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
    void shouldThrowIllegalStateExceptionWhenFromIsCalledBeforeSelect() {
        Query.Builder builder = new Query.Builder();
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from(f ->
                f.table(t -> t.name("User").as("u"))
        ));
    }

    @Test
    @DisplayName("call to select clause can only be called once")
    void shouldThrowIllegalStateExceptionWhenSelectIsCalledTwice() {
        Query.Builder builder = new Query.Builder();
        Assertions.assertThrows(IllegalStateException.class, () ->
            builder.select(s ->
                s.column(c -> c.of("u").name("name").as("pseudo"))
            ).select(s ->
                s.column(c -> c.of("a").name("street").as("location"))
            ));
    }
}
