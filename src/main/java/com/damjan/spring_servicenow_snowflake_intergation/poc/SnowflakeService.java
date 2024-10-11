package com.damjan.spring_servicenow_snowflake_intergation.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnowflakeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData(String firstName, String lastName, String city) {
        String sql = "INSERT INTO your_table_name (first_name, last_name, city) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, firstName, lastName, city);
    }
}
