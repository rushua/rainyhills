package com.rush.rainyhills.performance;

import com.rush.rainyhills.core.TwoWayLoopCalculator;
import com.rush.rainyhills.core.OneWayLoopCalculator;
import com.rush.rainyhills.middleware.WaterCalculator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

/**
 * Created by Ruslan Khalikov
 * Date: 17.06.2016
 * Time: 19:48
 */
public class VolumeCalculatorPerformanceTest {
    private WaterCalculator waterCalculator;
    private int[] hills;

    private int hillCount = 2000;
    private int maxInt = 100;

    @Before
    public void init() {
        Random random = new Random();

        hillCount = hillCount * 2;
        hills = new int[hillCount];
        for (int n = 0; n < hills.length; n++) {
            hills[n] = random.nextInt(maxInt);
        }

        waterCalculator = new WaterCalculator();
    }

    @Ignore
    @Test
    public void twoWayLoopPerformanceTest() {
        waterCalculator.setVolumeCalculator(new TwoWayLoopCalculator());
        long startTime = System.currentTimeMillis();
        waterCalculator.calculate(hills);
        System.out.println("TwoWayLoop calculator stream for " + hills.length
                + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Ignore
    @Test
    public void oneWayLoopPerformanceTest() {
        waterCalculator.setVolumeCalculator(new OneWayLoopCalculator());
        long startTime = System.currentTimeMillis();
        waterCalculator.calculate(hills);
        System.out.println("OneWayLoop calculator stream for " + hills.length
                + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void fullPerformanceTest() {
        System.out.println("Preparing...");
        for (int i = 0; i < 10; i++) {
            init();
            twoWayLoopPerformanceTest();
            oneWayLoopPerformanceTest();
        }
        System.out.println("Done!");
    }
}
