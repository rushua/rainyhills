package com.rush.wf;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 15:09
 */
public class VolumeCalculatorTest {
    private static class Item {
        private int[] flasks;
        private int volume;

        public Item(int[] flasks, int volume) {
            this.flasks = flasks;
            this.volume = volume;
        }

        public int[] getFlasks() {
            return flasks;
        }

        public int getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "flasks=" + Arrays.toString(flasks) +
                    ", volume=" + volume +
                    '}';
        }
    }

    private Item[] items = new Item[]{
            new Item(new int[]{3, 4, 7, 3, 4, 7, 6, 7, 2, 4}, 10),
            new Item(new int[]{6, 1, 5, 2, 1, 4}, 9),
            new Item(new int[]{5, 1, 3, 6, 1, 6, 1, 3, 1, 4}, 18),
            new Item(new int[]{5, 1, 3}, 2),
            new Item(new int[]{7, 1, 1, 1, 7, 1, 1, 1, 1, 7}, 42),
            new Item(new int[]{7, 1, 3, 6, 1, 5, 1, 7, 6, 5}, 25),
            new Item(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0),
            new Item(new int[]{7, 1, 5, 2, 1, 4}, 9),
            new Item(new int[]{2, 5, 1, 3, 1, 2, 1, 7, 7, 6}, 17),
            new Item(new int[]{5, 1, 5, 1, 5, 1, 5}, 12),
            new Item(new int[]{4, 1, 2, 5, 1, 6}, 9),
            new Item(new int[]{6, 1, 1, 1, 7, 1, 1, 1, 1, 7}, 39),
            new Item(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, 9),
            new Item(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 0),
            new Item(new int[]{7, 1, 5, 2, 1, 4, 2}, 9),
            new Item(new int[]{5, 1, 3, 6, 1, 5, 1, 7, 6, 5}, 17),
            new Item(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1}, 1),
            new Item(new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6}, 10),
            new Item(new int[]{5, 1, 4, 2, 3}, 4),
            new Item(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, 9),
            new Item(new int[]{1, 5, 1, 5, 1, 5, 1}, 8),
            new Item(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, 0),
    };

    @Test
    public void calculateFullTest() {
        Arrays.stream(items).forEach(
                item -> Assert.assertEquals("Failed: " + item, item.getVolume(), VolumeCalculator.calculate(item.getFlasks()))
        );
    }

    @Ignore
    @Test
    public void calculatePartTest() {
        Assert.assertEquals("Failed: " + items[0], items[0].getVolume(), VolumeCalculator.calculate(items[0].getFlasks()));
    }
}
