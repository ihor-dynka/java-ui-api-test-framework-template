package com.ihor_dynka.tests.controllers;

import rest_client.IRestApiRequest;
import rest_client.RestClient;
import rest_client.RestRequest;

public abstract class AbstractController {

    protected RestClient client() {
        return new RestClient();
    }

    protected IRestApiRequest baseAuthRequest(String token) {
        return new RestRequest().setOAuth2(token);
    }

    protected IRestApiRequest seedAdminAuthRequest(String token) {
        return new RestRequest().setHeader("Authorization", token);
    }
}
