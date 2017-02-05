package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:06
 */
public class RecursionCalculator extends VolumeCalculator {
    @Override
    public int[] calculateArray(int[] hills) {
        int[] volumes = new int[hills.length];
        return calculateArray(0, hills, volumes);
    }

    private int[] calculateArray(int offset, int[] hills, int[] volumes) {
        int end = maxHillIndex(offset + 1, hills);
        if (end < hills.length) {
            int blockHill = Math.min(hills[offset], hills[end]);

            offset = offset + 1;
            for (int i = offset; i < end; i++) {
                if (hills[i] > blockHill) {
                    blockHill = hills[i];
                } else {
                    volumes[i] = blockHill - hills[i];
                }
            }

            offset = end;
            volumes = calculateArray(offset, hills, volumes);
        }
        return volumes;
    }

    private int maxHillIndex(int offset, int[] hills) {
        int maxHill = 0;
        int maxHillIndex = offset;
        for (int i = offset; i < hills.length; i++) {
            if (hills[i] > maxHill) {
                maxHill = hills[i];
                maxHillIndex = i;
            }
        }
        return maxHillIndex;
    }
}
