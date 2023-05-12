package rest_client;

import com.github.viclovsky.swagger.coverage.SwaggerCoverageRestAssured;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.mapper.ObjectMapperType;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class RestClient implements IRestClient {

    @Override
    public RestClient baseConfigure() {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
        return this;
    }

    @Override
    public RestResponse doGet(String url, IRestApiRequest request) {
        return new RestResponse(
                RestAssured
                        .given()
                        .spec(request.getRequestSpecification())
                        .when()
                        .get(url));
    }

    @Override
    public RestResponse doPost(String url, IRestApiRequest request) {
        return new RestResponse(
                RestAssured
                        .given()
                        .spec(request.getRequestSpecification())
                        .when()
                        .post(url)
        );
    }

    @Override
    public RestResponse doPut(String url, IRestApiRequest request) {
        return new RestResponse(
                RestAssured
                        .given()
                        .spec(request.getRequestSpecification())
                        .when()
                        .put(url)
        );
    }

    @Override
    public RestResponse doDelete(String url, IRestApiRequest request) {
        return new RestResponse(
                RestAssured
                        .given()
                        .spec(request.getRequestSpecification())
                        .when()
                        .delete(url)
        );
    }

    @Override
    public RestClient enableRequestLogging(boolean enable) {
        if (enable) {
            RestAssured.filters(new RequestLoggingFilter());
        }
        return this;
    }

    @Override
    public RestClient enableResponseLogging(boolean enable) {
        if (enable) {
            RestAssured.filters(new ResponseLoggingFilter());
        }
        return this;
    }

    @Override
    public RestClient enableAllureReporting(boolean enable) {
        if (enable) {
            RestAssured.filters(new AllureRestAssured());
        }
        return this;
    }

    @Override
    public RestClient enableSwaggerCoverage(boolean enable) {
        if (enable) {
            RestAssured.filters(new SwaggerCoverageRestAssured());
        }
        return this;
    }

    @Override
    public IRestClient setBaseUrl(String url) {
        RestAssured.baseURI = url;
        return this;
    }

    @Override
    public IRestClient setBasePath(String basePath) {
        RestAssured.basePath = basePath;
        return this;
    }

    @Override
    public IRestClient resetConfiguration() {
        RestAssured.reset();
        return this;
    }
}
