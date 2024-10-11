package com.damjan.spring_servicenow_snowflake_intergation.poc;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ServiceNowClient {

    @Value("${servicenow.api.url}")
    private String apiUrl;

    @Value("${servicenow.username}")
    private String username;

    @Value("${servicenow.password}")
    private String password;

    public String getDataFromServiceNow() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);
        request.setHeader("Authorization", "Basic " +
                Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        CloseableHttpResponse response = httpClient.execute(request);
        String jsonResponse = EntityUtils.toString(response.getEntity());
        httpClient.close();

        return jsonResponse;
    }
}
