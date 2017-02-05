package com.rush.rainyhills;

import java.util.Arrays;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 0:19
 */
public abstract class TestItemUtil {
    private static TestItem[] testItems = new TestItem[]{
            new TestItem(new int[]{}, new int[]{}, 0),
            new TestItem(new int[]{1}, new int[]{1}, 0),
            new TestItem(new int[]{1, 2}, new int[]{1, 2}, 0),
            new TestItem(new int[]{2, 1}, new int[]{2, 1}, 0),
            new TestItem(new int[]{2, 1, 2}, new int[]{2, 2, 2}, 1),
            new TestItem(new int[]{1, 2, 1}, new int[]{1, 2, 1}, 0),
            new TestItem(new int[]{3, 1, 2}, new int[]{3, 2, 2}, 1),
            new TestItem(new int[]{2, 1, 3}, new int[]{2, 2, 3}, 1),
            new TestItem(new int[]{2, 2, 2}, new int[]{2, 2, 2}, 0),
            new TestItem(new int[]{2, 2, 3}, new int[]{2, 2, 3}, 0),
            new TestItem(new int[]{3, 2, 2}, new int[]{3, 2, 2}, 0),
            new TestItem(new int[]{3, 4, 7, 3, 4, 7, 6, 7, 2, 4}, new int[]{3, 4, 7, 7, 7, 7, 7, 7, 4, 4}, 10),
            new TestItem(new int[]{6, 1, 5, 2, 1, 4}, new int[]{6, 5, 5, 4, 4, 4}, 9),
            new TestItem(new int[]{5, 1, 3, 6, 1, 6, 1, 3, 1, 4}, new int[]{5, 5, 5, 6, 6, 6, 4, 4, 4, 4}, 18),
            new TestItem(new int[]{5, 1, 3}, new int[]{5, 3, 3}, 2),
            new TestItem(new int[]{7, 1, 1, 1, 7, 1, 1, 1, 1, 7}, new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, 42),
            new TestItem(new int[]{7, 1, 3, 6, 1, 5, 1, 7, 6, 5}, new int[]{7, 7, 7, 7, 7, 7, 7, 7, 6, 5}, 25),
            new TestItem(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4}, new int[]{7, 5, 5, 4, 4, 4}, 9),
            new TestItem(new int[]{2, 5, 1, 3, 1, 2, 1, 7, 7, 6}, new int[]{2, 5, 5, 5, 5, 5, 5, 7, 7, 6}, 17),
            new TestItem(new int[]{5, 1, 5, 1, 5, 1, 5}, new int[]{5, 5, 5, 5, 5, 5, 5}, 12),
            new TestItem(new int[]{4, 1, 2, 5, 1, 6}, new int[]{4, 4, 4, 5, 5, 6}, 9),
            new TestItem(new int[]{6, 1, 1, 1, 7, 1, 1, 1, 1, 7}, new int[]{6, 6, 6, 6, 7, 7, 7, 7, 7, 7}, 39),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, new int[]{7, 5, 5, 4, 4, 4, 3, 2}, 9),
            new TestItem(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 0),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 2}, new int[]{7, 5, 5, 4, 4, 4, 2}, 9),
            new TestItem(new int[]{5, 1, 3, 6, 1, 5, 1, 7, 6, 5}, new int[]{5, 5, 5, 6, 6, 6, 6, 7, 6, 5}, 17),
            new TestItem(new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1}, new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1}, 1),
            new TestItem(new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6}, new int[]{2, 5, 5, 5, 5, 5, 7, 7, 6}, 10),
            new TestItem(new int[]{6, 7, 7, 4, 3, 2, 1, 5, 2}, new int[]{6, 7, 7, 5, 5, 5, 5, 5, 2}, 10),
            new TestItem(new int[]{5, 1, 4, 2, 3}, new int[]{5, 4, 4, 3, 3}, 4),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, new int[]{7, 5, 5, 4, 4, 4, 3, 2}, 9),
            new TestItem(new int[]{1, 5, 1, 5, 1, 5, 1}, new int[]{1, 5, 5, 5, 5, 5, 1}, 8),
            new TestItem(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, 0),
    };

    public static class TestItem {
        private int[] emptyHills;
        private int[] fullHills;
        private int volume;

        public TestItem(int[] emptyHills, int[] fullHills, int volume) {
            this.emptyHills = emptyHills;
            this.fullHills = fullHills;
            this.volume = volume;
        }

        public int[] getEmptyHills() {
            return emptyHills;
        }

        public int[] getFullHills() {
            return fullHills;
        }

        public int getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "TestItem{" +
                    "emptyHills=" + Arrays.toString(emptyHills) +
                    ", fullHills=" + Arrays.toString(fullHills) +
                    ", volume=" + volume +
                    '}';
        }
    }

    public static TestItem[] createTestItems() {
        TestItem[] items = new TestItem[testItems.length];
        System.arraycopy(testItems, 0, items, 0, testItems.length);
        return items;
    }

    public static int[] fullHills(int[] emptyHills, int[] volume) {
        int[] fullHills = new int[emptyHills.length];
        for (int i = 0; i < emptyHills.length; i++) {
            fullHills[i] = emptyHills[i] + volume[i];
        }
        return fullHills;
    }

    public static int[] volumes(int[] emptyHills, int[] fullHills) {
        int[] volumes = new int[emptyHills.length];
        for (int i = 0; i < emptyHills.length; i++) {
            volumes[i] = fullHills[i] - emptyHills[i];
        }
        return volumes;
    }
}
