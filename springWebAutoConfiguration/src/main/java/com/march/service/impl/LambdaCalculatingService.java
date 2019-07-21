package com.march.service.impl;

import com.march.service.CalculatingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
@Profile("Java8")
public class LambdaCalculatingService implements CalculatingService {

    public Integer sum(Integer... values) {

        int sum = Stream.of(values).reduce(0,Integer::sum);

        System.out.printf("[Java 8 lambda实现] %s 累加结果：%d\n", Arrays.asList(values),sum);

        return sum;
    }
}
