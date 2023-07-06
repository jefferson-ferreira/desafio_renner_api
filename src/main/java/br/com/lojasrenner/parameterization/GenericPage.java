package br.com.lojasrenner.parameterization;

import org.junit.jupiter.api.BeforeEach;
import static io.restassured.RestAssured.*;

public class GenericPage {
    @BeforeEach
    public void initialize() {
        baseURI = "https://reqres.in";
        basePath = "/api";
    }
}
