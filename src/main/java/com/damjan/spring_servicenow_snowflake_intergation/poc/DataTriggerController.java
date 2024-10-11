package com.damjan.spring_servicenow_snowflake_intergation.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTriggerController {

    @Autowired
    private DataIntegrationService dataIntegrationService;

    @GetMapping("/trigger")
    public String triggeredTask() throws Exception {
        dataIntegrationService.processData();

        return "200" +
                "Saved to Snowflake";
    }
}
