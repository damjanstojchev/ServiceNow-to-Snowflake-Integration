package com.damjan.spring_servicenow_snowflake_intergation.poc;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SnowflakeClient {
    @Value("${snowflake.url}")
    private String snowflakeUrl;

    @Value("${snowflake.username}")
    private String username;

    @Value("${snowflake.password}")
    private String password;

    @Value("${snowflake.database}")
    private String database;

    @Value("${snowflake.schema}")
    private String schema;

    public Connection getSnowflakeConnection() throws SQLException {
        String connectionUrl = String.format("%s?db=%s&schema=%s",
                snowflakeUrl, database, schema);
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
