package com.march.service.impl;

import com.march.service.CalculatingService;

import java.util.Arrays;

public class IterationCalculatingService implements CalculatingService {

    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for(Integer value : values){
            sum += value;
        }

        System.out.printf("[Java 7 迭代实现] %s 累加结果：%d\n", Arrays.asList(values),sum);

        return sum;
    }
}
