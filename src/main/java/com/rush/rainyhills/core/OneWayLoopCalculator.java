package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:06
 */
public class OneWayLoopCalculator extends VolumeCalculator {
    @Override
    public int[] calculateArray(int[] hills) {
        int[] volumes = new int[hills.length];
        if (hills.length > 0) {
            int max = hills[0];
            for (int i = 0; i < hills.length; i++) {
                int volume;
                if (max > hills[i]) {
                    volume = max - hills[i];
                } else {
                    volume = 0;
                    max = hills[i];
                    max = Math.min(max, hills[maxHillIndex(i + 1, hills)]);
                }
                volumes[i] = volume;
            }
        }
        return volumes;
    }

    private int maxHillIndex(int offset, int[] hills) {
        int maxHill = 0;
        int maxHillIndex = 0;
        for (int i = offset; i < hills.length; i++) {
            if (hills[i] > maxHill) {
                maxHill = hills[i];
                maxHillIndex = i;
            }
        }
        return maxHillIndex;
    }
}
