package com.ivanizv.postgresql.backend.service;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostgresqlService {

    private static final Logger log = LoggerFactory.getLogger(PostgresqlService.class);
    private final NamedParameterJdbcTemplate jdbcTemplate;


    public PostgresqlService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String getDatabaseVersion() {

        var selectVersion = "SELECT version();";

        var result = jdbcTemplate.queryForObject(selectVersion, Collections.emptyMap(), String.class);

        log.info("В базу данных PostgreSQL отправлен запрос \"SELECT version();\" и получен результат: {}", result);

        return result;

    }

}
