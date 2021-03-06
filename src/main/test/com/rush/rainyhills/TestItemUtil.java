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
            new TestItem(new int[]{1}, new int[]{0}, 0),
            new TestItem(new int[]{1, 2}, new int[]{0, 0}, 0),
            new TestItem(new int[]{2, 1}, new int[]{0, 0}, 0),
            new TestItem(new int[]{2, 1, 2}, new int[]{0, 1, 0}, 1),
            new TestItem(new int[]{1, 2, 1}, new int[]{0, 0, 0}, 0),
            new TestItem(new int[]{3, 1, 2}, new int[]{0, 1, 0}, 1),
            new TestItem(new int[]{2, 1, 3}, new int[]{0, 1, 0}, 1),
            new TestItem(new int[]{2, 2, 2}, new int[]{0, 0, 0}, 0),
            new TestItem(new int[]{2, 2, 3}, new int[]{0, 0, 0}, 0),
            new TestItem(new int[]{3, 2, 2}, new int[]{0, 0, 0}, 0),
            new TestItem(new int[]{3, 4, 7, 3, 4, 7, 6, 7, 2, 4}, new int[]{0, 0, 0, 4, 3, 0, 1, 0, 2, 0}, 10),
            new TestItem(new int[]{6, 1, 5, 2, 1, 4}, new int[]{0, 4, 0, 2, 3, 0}, 9),
            new TestItem(new int[]{5, 1, 3, 6, 1, 6, 1, 3, 1, 4}, new int[]{0, 4, 2, 0, 5, 0, 3, 1, 3, 0}, 18),
            new TestItem(new int[]{5, 1, 3}, new int[]{0, 2, 0}, 2),
            new TestItem(new int[]{7, 1, 1, 1, 7, 1, 1, 1, 1, 7}, new int[]{0, 6, 6, 6, 0, 6, 6, 6, 6, 0}, 42),
            new TestItem(new int[]{7, 1, 3, 6, 1, 5, 1, 7, 6, 5}, new int[]{0, 6, 4, 1, 6, 2, 6, 0, 0, 0}, 25),
            new TestItem(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4}, new int[]{0, 4, 0, 2, 3, 0}, 9),
            new TestItem(new int[]{2, 5, 1, 3, 1, 2, 1, 7, 7, 6}, new int[]{0, 0, 4, 2, 4, 3, 4, 0, 0, 0}, 17),
            new TestItem(new int[]{5, 1, 5, 1, 5, 1, 5}, new int[]{0, 4, 0, 4, 0, 4, 0}, 12),
            new TestItem(new int[]{4, 1, 2, 5, 1, 6}, new int[]{0, 3, 2, 0, 4, 0}, 9),
            new TestItem(new int[]{6, 1, 1, 1, 7, 1, 1, 1, 1, 7}, new int[]{0, 5, 5, 5, 0, 6, 6, 6, 6, 0}, 39),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, new int[]{0, 4, 0, 2, 3, 0, 0, 0}, 9),
            new TestItem(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 2}, new int[]{0, 4, 0, 2, 3, 0, 0}, 9),
            new TestItem(new int[]{5, 1, 3, 6, 1, 5, 1, 7, 6, 5}, new int[]{0, 4, 2, 0, 5, 1, 5, 0, 0, 0}, 17),
            new TestItem(new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 1),
            new TestItem(new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6}, new int[]{0, 0, 4, 3, 2, 1, 0, 0, 0}, 10),
            new TestItem(new int[]{6, 7, 7, 4, 3, 2, 1, 5, 2}, new int[]{0, 0, 0, 1, 2, 3, 4, 0, 0}, 10),
            new TestItem(new int[]{5, 1, 4, 2, 3}, new int[]{0, 3, 0, 1, 0}, 4),
            new TestItem(new int[]{7, 1, 5, 2, 1, 4, 3, 2}, new int[]{0, 4, 0, 2, 3, 0, 0, 0}, 9),
            new TestItem(new int[]{1, 5, 1, 5, 1, 5, 1}, new int[]{0, 0, 4, 0, 4, 0, 0}, 8),
            new TestItem(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0),
    };

    public static class TestItem {
        private int[] hills;
        private int[] volumes;
        private int total;

        public TestItem(int[] hills, int[] volumes, int total) {
            this.hills = hills;
            this.volumes = volumes;
            this.total = total;
        }

        public int[] getHills() {
            return hills;
        }

        public int[] getVolumes() {
            return volumes;
        }

        public int getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "TestItem{" +
                    "hills=" + Arrays.toString(hills) +
                    ", volumes=" + Arrays.toString(volumes) +
                    ", total=" + total +
                    '}';
        }
    }

    public static TestItem[] createTestItems() {
        TestItem[] items = new TestItem[testItems.length];
        System.arraycopy(testItems, 0, items, 0, testItems.length);
        return items;
    }
}
