package rest_client;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class RestResponse implements IRestApiResponse {

    private final Response response;

    public RestResponse(Response response) {
        this.response = response;
    }

    @Override
    public RestResponse statusCodeShouldBe(ResponseStatusCode statusCode) {
        this.response.then()
                .assertThat()
                .statusCode(statusCode.getStatusCode());
        return this;
    }

    @Override
    public <T> T getResponse(Class<T> tClass) {
        return this.response
                .then()
                .extract()
                .as(tClass);
    }

    @SneakyThrows
    @Override
    public RestResponse validateJsonSchema(String jsonSchema) {
        this.response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json_schema/" + jsonSchema));
        return this;
    }
}
