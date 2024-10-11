package com.damjan.spring_servicenow_snowflake_intergation.poc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataIntegrationService {

    @Autowired
    private ServiceNowClient serviceNowClient;

    @Autowired
    private SnowflakeService snowflakeService;

    public void processData() throws Exception {
        String jsonData = serviceNowClient.getDataFromServiceNow();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonData);

        jsonNode.get("result").forEach(node -> {
            String callerId = node.get("caller_id").asText();
            String short_description = node.get("short_description").asText();
            String number = node.get("number").asText();
            snowflakeService.insertData(callerId, short_description, number);
        });
    }
}
