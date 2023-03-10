package com.kokalam.sql.request;

import com.kokalam.sql.request.column.Column;
import com.kokalam.sql.request.table.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelectFromTest {

    @Test
    @DisplayName("select all column from table User")
    public void shouldReturnQueryWithAllColumnFromTableUser() {
        final String expectedQuery = "SELECT * FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select()
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name from table User")
    public void shouldReturnQueryWithOneColumnFromTableUser() {
        final String expectedQuery = "SELECT name FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select("name")
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name and surname from table User")
    public void shouldReturnQueryWithTwoColumnFromTableUser() {
        final String expectedQuery = "SELECT name,surname FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select("name", "surname")
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name as pseudo from table User")
    public void shouldReturnQueryWithOneColumnAsFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(Column.column("name").as("pseudo"))
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name as pseudo and surname from table User")
    public void shouldReturnQueryWithOneColumnAsAndOneColumnFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo,surname FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(Column.column("name").as("pseudo"), Column.column("surname"))
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name as pseudo and surname as family_name from table User")
    public void shouldReturnQueryWithTwoColumnAsFromTableUser() {
        final String expectedQuery = "SELECT name as pseudo,surname as family_name  FROM User";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(
                    Column.column("name").as("pseudo"),
                    Column.column("surname").as("family_name")
                )
                .from("User")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name from table User as u and column street from table Address as a")
    public void shouldReturnQueryWithTwoColumnAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name,a.street FROM User u,Address a";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(
                        Column.column("u","name"),
                        Column.column("a","street")
                )
                .from(Table.table("User").as("u"), Table.table("Address").as("a"))
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name from table User and column street from table Address")
    public void shouldReturnQueryWithTwoColumnAsFromTwoTable() {
        final String expectedQuery = "SELECT User.name,Address.street FROM User,Address";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(
                        Column.column("User","name"),
                        Column.column("Address","street")
                )
                .from("User", "Address")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("select column name as pseudo from table User and column street as location from table Address")
    public void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTable() {
        final String expectedQuery = "SELECT name as pseudo,street as location FROM User,Address";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(
                        Column.column("name").as("pseudo"),
                        Column.column("street").as("location")
                )
                .from("User", "Address")
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("should select column name as pseudo from table User as u and column street as location from table Address as a")
    public void shouldReturnQueryWithTwoColumnWithAliasAsFromTwoTableWithAlias() {
        final String expectedQuery = "SELECT u.name as pseudo,a.street as location FROM User,Address";
        Request.Builder builder = new Request.Builder();
        Request request = builder.select(
                        Column.column("u", "name").as("pseudo"),
                        Column.column("a", "street").as("location")
                )
                .from(Table.table("User").as("u"), Table.table("Address").as("a"))
                .build();

        Assertions.assertEquals(expectedQuery, request.get());
    }

    @Test
    @DisplayName("call from clause before select clause")
    public void shouldThrowIllegalStateExceptionWhenFromIsCalledBeforeSelect() {
        Request.Builder builder = new Request.Builder();
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from("User"));
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from("User", "Address"));
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from(Table.table("User")));
        Assertions.assertThrows(IllegalStateException.class, () -> builder.from(Table.table("User"), Table.table("Address")));
    }
}
