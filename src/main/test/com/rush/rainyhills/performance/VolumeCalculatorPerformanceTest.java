package com.rush.rainyhills.performance;

import com.rush.rainyhills.TestItemUtil;
import com.rush.rainyhills.core.LoopCalculator;
import com.rush.rainyhills.core.RecursionCalculator;
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
    private TestItemUtil.TestItem[] items;
    private WaterCalculator waterCalculator;
    private int itemCount = 1000;

    @Before
    public void init() {
        Random random = new Random();
        itemCount = itemCount * 2;
        int[] hills = new int[itemCount];
        for (int i = 0; i < itemCount; i++) {
            hills[i] = Math.abs(random.nextInt());
        }
        TestItemUtil.TestItem item = new TestItemUtil.TestItem(hills, hills, 0);

        List<TestItemUtil.TestItem> itemList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            itemList.add(item);
        }
        items = new TestItemUtil.TestItem[itemList.size()];
        itemList.toArray(items);

        waterCalculator = new WaterCalculator();
    }

    @Ignore
    @Test
    public void loopPerformanceTest() {
        waterCalculator.setVolumeCalculator(new LoopCalculator());
        long startTime = System.currentTimeMillis();
        Arrays.stream(items).forEach(item -> waterCalculator.calculate(item.getEmptyHills()));
        System.out.println("Loop calculator stream for " + items[0].getEmptyHills().length
                + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Ignore
    @Test
    public void recursionPerformanceTest() {
        waterCalculator.setVolumeCalculator(new RecursionCalculator());
        long startTime = System.currentTimeMillis();
        Arrays.stream(items).forEach(item -> waterCalculator.calculate(item.getEmptyHills()));
        System.out.println("Recursion calculator stream for " + items[0].getEmptyHills().length
                + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void fullPerformanceTest() {
        System.out.println("Preparing...");
        for (int i = 0; i < 10; i++) {
            init();
            loopPerformanceTest();
            recursionPerformanceTest();
        }
        System.out.println("Done!");
    }
}
