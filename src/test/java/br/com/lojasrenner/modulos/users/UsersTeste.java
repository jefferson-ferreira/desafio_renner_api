package br.com.lojasrenner.modulos.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.lojasrenner.dataFactory.UsersDataFactory;
import br.com.lojasrenner.parameterization.GenericPage;
import br.com.lojasrenner.pojo.UsersPojo;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import org.apache.http.HttpStatus;


@DisplayName("Users Module API Tests")
public class UsersTeste extends GenericPage {
    static String id = null;
    
    @Test
    @DisplayName("Create user successfully")
    public void testCreateUserSuccessfully() throws IOException {

        UsersPojo createUser = UsersDataFactory.createUserSuccessfully();

        id = given()
            .contentType(ContentType.JSON)
            .body(createUser)
        .when()
            .post("/users")
        .then()
            .statusCode(HttpStatus.SC_CREATED)
            .assertThat()
                .body("name", equalTo("Jefferson Ferreira Faria"))
                .body("job", equalTo("QA Engineer"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())
            .extract()
                .path("id")
        ;
    }

    @Test
    @DisplayName("Query User by id")
    public void testQueryUserById() {

        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users/2")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .rootPath("data")
                .body("id", equalTo(2))
                .body("email", equalTo("janet.weaver@reqres.in"))
                .body("first_name", equalTo("Janet"))
                .body("last_name", equalTo("Weaver"))
                .body("avatar", notNullValue())
                .rootPath("support")
                .body("url", equalTo("https://reqres.in/#support-heading"))
                .body("text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }

    @Test
    @DisplayName("Query Users")
    public void testQueryUsers() {

        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2))
                .rootPath("support")
                .body("url", equalTo("https://reqres.in/#support-heading"))
                .body("text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
        ;
    }

    @Test
    @DisplayName("Change User by id")
    public void testChangeUserById() throws IOException {

        UsersPojo changeUser = UsersDataFactory.changeUserSuccessfully();

        given()
            .contentType(ContentType.JSON)
            .body(changeUser)
        .when()
            .patch("/users/" + id)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .body("name", equalTo("Ricardo de Souza"))
                .body("job", equalTo("Developed"))
                .body("updatedAt", notNullValue())
        ;
    }
}
