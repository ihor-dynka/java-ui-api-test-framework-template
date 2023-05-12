package rest_client;

public interface IRestApiRequest {
    IRestApiRequest setContentType(String contentType);

    IRestApiRequest setParam(String name, String value);

    IRestApiRequest setOAuth2(String token);

    IRestApiRequest setBody(Object body);

    IRestApiRequest setHeader(String headerName, Object headerValue);

    <T> T getRequestSpecification();
}
