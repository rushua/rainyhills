package com.rush.rainyhills.core;

import com.rush.rainyhills.TestItemUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 21:09
 */
public class VolumeCalculatorTest {
    private TestItemUtil.TestItem[] items;
    private VolumeCalculator volumeCalculator;

    @Before
    public void init() {
        items = TestItemUtil.createTestItems();
        volumeCalculator = new VolumeCalculator();
    }

    @Test
    public void fullLoopCalculateTest() {
        volumeCalculator.setVolumeCalculator(new LoopCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertEquals("Failed: " + item, item.getVolume(), volumeCalculator.calculate(item.getEmptyHills()))
        );
    }

    @Test
    public void fullRecursionCalculateTest() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertEquals("Failed: " + item, item.getVolume(), volumeCalculator.calculate(item.getEmptyHills()))
        );
    }

    @Test
    public void fullLoopHillCalculateTest() {
        volumeCalculator.setVolumeCalculator(new LoopCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), volumeCalculator.calculateHills(item.getEmptyHills()))
        );
    }

    @Test
    public void fullRecursionHillCalculateTest() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
        Arrays.stream(items).forEach(
                item -> Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), volumeCalculator.calculateHills(item.getEmptyHills()))
        );
    }

    @Ignore
    @Test
    public void partCalculateTest() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
        TestItemUtil.TestItem item = items[28];
        Assert.assertEquals("Failed: " + item, item.getVolume(), volumeCalculator.calculate(item.getEmptyHills()));
    }

    @Ignore
    @Test
    public void partHillCalculateTest() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
        TestItemUtil.TestItem item = items[28];
        Assert.assertArrayEquals("Failed: " + item, item.getFullHills(), volumeCalculator.calculateHills(item.getEmptyHills()));
    }
}
