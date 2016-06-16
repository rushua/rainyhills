package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:19
 */
public class LoopCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] hills) {
        int volume = 0;

        int maxLeft = 0;
        int maxRight = 0;
        int indexLeft = 0;
        int indexRight = hills.length - 1;

        while (indexLeft < indexRight) {
            if (hills[indexLeft] > maxLeft) maxLeft = hills[indexLeft];
            if (hills[indexRight] > maxRight) maxRight = hills[indexRight];

            volume += maxLeft < maxRight ? maxLeft - hills[indexLeft++] : maxRight - hills[indexRight--];
        }

        return volume;
    }
}
