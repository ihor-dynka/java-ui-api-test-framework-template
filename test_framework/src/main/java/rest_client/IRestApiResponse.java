package rest_client;

public interface IRestApiResponse {
    IRestApiResponse statusCodeShouldBe(ResponseStatusCode statusCode);

    <T> T getResponse(Class<T> tClass);

    IRestApiResponse validateJsonSchema(String jsonSchema);
}
