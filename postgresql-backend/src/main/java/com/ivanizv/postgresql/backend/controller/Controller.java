package com.ivanizv.postgresql.backend.controller;

import java.util.Map;
import com.ivanizv.postgresql.backend.exception.RandomException;
import com.ivanizv.postgresql.backend.service.PostgresqlService;
import com.ivanizv.postgresql.backend.service.RandomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private final PostgresqlService postgresqlService;
    private final RandomService randomService;


    public Controller(PostgresqlService postgresqlService, RandomService randomService) {
        this.postgresqlService = postgresqlService;
        this.randomService = randomService;
    }


    @GetMapping("/database/version")
    @ResponseStatus(HttpStatus.OK)
    public String getDatabaseVersion() {

        log.info("Получен GET запрос на endpoint /database/version");

        return postgresqlService.getDatabaseVersion();
    }


    @PostMapping("/random/number")
    @ResponseStatus(HttpStatus.CREATED)
    public int getRandomNumber(@RequestBody Map<String, Integer> params) throws RandomException {

        var min = params.get("min");
        var max = params.get("max");

        log.info("Получен POST запрос на endpoint /random/number и числа: min = {}, max = {}", min, max);

        return randomService.getRandomNumber(min, max);
    }

}
