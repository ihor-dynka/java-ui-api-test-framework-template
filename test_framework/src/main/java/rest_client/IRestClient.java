package rest_client;

public interface IRestClient {
    RestClient baseConfigure();

    RestResponse doGet(String url, IRestApiRequest request);

    RestResponse doPost(String url, IRestApiRequest request);

    RestResponse doPut(String url, IRestApiRequest request);

    RestResponse doDelete(String url, IRestApiRequest request);

    RestClient enableRequestLogging(boolean enable);

    RestClient enableResponseLogging(boolean enable);

    RestClient enableAllureReporting(boolean enable);

    RestClient enableSwaggerCoverage(boolean enable);

    IRestClient setBaseUrl(String url);

    IRestClient setBasePath(String path);

    IRestClient resetConfiguration();
}
