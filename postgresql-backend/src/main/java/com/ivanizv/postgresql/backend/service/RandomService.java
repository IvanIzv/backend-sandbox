package com.ivanizv.postgresql.backend.service;

import java.util.Random;
import com.ivanizv.postgresql.backend.exception.RandomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RandomService {

    private static final Logger log = LoggerFactory.getLogger(RandomService.class);


    public int getRandomNumber(int min, int max) throws RandomException {

        if (min > max) {

            var errorMessage = "ОШИБКА, потому что: min = " + min + ", max = " + max + ", min больше max";

            throw new RandomException(errorMessage);

        } else if (min == max) {

            log.warn("ПРЕДУПРЕЖДЕНИЕ: min = {}, max = {}, min и max равны, поэтому max увеличиваеться на +1", min, max);

            max = max + 1;

        }

        var randomInt = new Random().nextInt(min, max);

        log.info("Сгенерировано случайное число {}, в диапозоне min = {}, max = {}", randomInt, min, max);

        return randomInt;

    }

}
