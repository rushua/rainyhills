package com.rush.rainyhills.performance;

import com.rush.rainyhills.TestItemUtil;
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
    private TestItemUtil.TestItem item;
    private int hillCount = 10000;
    private int maxInt = 100;

    @Before
    public void init() {
        Random random = new Random();

        hillCount = hillCount * 2;
        int[] hills = new int[hillCount];
        for (int n = 0; n < hills.length; n++) {
            hills[n] = random.nextInt(maxInt);
        }

        item = new TestItemUtil.TestItem(hills, hills, 0);

        waterCalculator = new WaterCalculator();
    }

    @Ignore
    @Test
    public void twoWayLoopPerformanceTest() {
        waterCalculator.setVolumeCalculator(new TwoWayLoopCalculator());
        long startTime = System.currentTimeMillis();
        waterCalculator.calculate(item.getHills());
        System.out.println("Loop calculator stream for " + item.getHills().length
                + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Ignore
    @Test
    public void oneWayLoopPerformanceTest() {
        waterCalculator.setVolumeCalculator(new OneWayLoopCalculator());
        long startTime = System.currentTimeMillis();
        waterCalculator.calculate(item.getHills());
        System.out.println("Recursion calculator stream for " + item.getHills().length
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
