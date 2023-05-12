package rest_client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class RestRequest implements IRestApiRequest {

    private final RequestSpecification requestSpecification;

    public RestRequest() {
        requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.contentType(ContentType.JSON);
    }

    @Override
    public IRestApiRequest setContentType(String contentType) {
        requestSpecification.contentType(contentType);
        return this;
    }

    @Override
    public IRestApiRequest setParam(String name, String value) {
        requestSpecification.param(name, value);
        return this;
    }

    @Override
    public IRestApiRequest setOAuth2(String token) {
        requestSpecification.auth().oauth2(token);
        return this;
    }

    @Override
    public IRestApiRequest setBody(Object body) {
        requestSpecification.body(body);
        return this;
    }

    @Override
    public IRestApiRequest setHeader(String headerName, Object headerValue) {
        requestSpecification.header(headerName, headerValue);
        return this;
    }
}
