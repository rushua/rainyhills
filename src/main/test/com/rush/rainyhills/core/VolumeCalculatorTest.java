package com.rush.rainyhills.core;

import com.rush.rainyhills.TestItemUtil;
import com.rush.rainyhills.middleware.WaterCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static com.rush.rainyhills.TestItemUtil.fullHills;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 21:09
 */
public class VolumeCalculatorTest {
    private TestItemUtil.TestItem[] items;
    private WaterCalculator waterCalculator;

    @Before
    public void init() {
        items = TestItemUtil.createTestItems();
        waterCalculator = new WaterCalculator();
    }

    @Test
    public void volumeLoopCalculateTest() {
        waterCalculator.setVolumeCalculator(new LoopCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertEquals("Failed: " + item, item.getVolume(), waterCalculator.calculate(item.getEmptyHills()))
        );
    }

    @Test
    public void volumeRecursionCalculateTest() {
        waterCalculator.setVolumeCalculator(new RecursionCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertEquals("Failed: " + item, item.getVolume(), waterCalculator.calculate(item.getEmptyHills()))
        );
    }

    @Test
    public void arrayLoopCalculateTest() {
        waterCalculator.setVolumeCalculator(new LoopCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), fullHills(item.getEmptyHills(), waterCalculator.calculateArray(item.getEmptyHills())))
        );
    }

    @Test
    public void arrayRecursionCalculateTest() {
        waterCalculator.setVolumeCalculator(new RecursionCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), fullHills(item.getEmptyHills(), waterCalculator.calculateArray(item.getEmptyHills())))
        );
    }

    @Ignore
    @Test
    public void partVolumeCalculateTest() {
        waterCalculator.setVolumeCalculator(new RecursionCalculator());
        TestItemUtil.TestItem item = items[28];
        Assert.assertEquals("Failed: " + item, item.getVolume(), waterCalculator.calculate(item.getEmptyHills()));
    }

    @Ignore
    @Test
    public void partArrayCalculateTest() {
        waterCalculator.setVolumeCalculator(new RecursionCalculator());
        TestItemUtil.TestItem item = items[28];
        Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), fullHills(item.getEmptyHills(), waterCalculator.calculateArray(item.getEmptyHills())));
    }
}
