package com.rush.rainyhills.performance;

import com.rush.rainyhills.TestItemUtil;
import com.rush.rainyhills.core.LoopCalculator;
import com.rush.rainyhills.core.RecursionCalculator;
import com.rush.rainyhills.core.VolumeCalculator;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

/**
 * Created by Ruslan Khalikov
 * Date: 17.06.2016
 * Time: 19:48
 */
public class VolumeCalculatorPerformanceTest {
    private static TestItemUtil.TestItem[] items;
    private static VolumeCalculator volumeCalculator;

    @BeforeClass
    public static void init() {
        Random random = new Random();
        int length = 1000000;
        int[] hills = new int[length];
        for (int i = 0; i < length; i++) {
            hills[i] = Math.abs(random.nextInt());
        }
        TestItemUtil.TestItem item = new TestItemUtil.TestItem(hills, hills, 0);

        List<TestItemUtil.TestItem> itemList = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            itemList.add(item);
        }
        items = new TestItemUtil.TestItem[itemList.size()];
        itemList.toArray(items);

        volumeCalculator = new VolumeCalculator();
    }

    @Ignore
    @Test
    public void loopPerformanceTest() {
        volumeCalculator.setVolumeCalculator(new LoopCalculator());
        long startTime = System.currentTimeMillis();
        Arrays.stream(items).forEach(item -> volumeCalculator.calculate(item.getEmptyHills()));
        System.out.println("Loop calculator stream for " + items.length + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Ignore
    @Test
    public void recursionPerformanceTest() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
        long startTime = System.currentTimeMillis();
        Arrays.stream(items).forEach(item -> volumeCalculator.calculate(item.getEmptyHills()));
        System.out.println("Recursion calculator stream for " + items.length + " item(s) -> " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void fullPerformanceTest() {
        System.out.println("Preparing...");
        for (int i = 0; i < 15; i++) {
            loopPerformanceTest();
            recursionPerformanceTest();
        }
        System.out.println("Done!");
    }
}
