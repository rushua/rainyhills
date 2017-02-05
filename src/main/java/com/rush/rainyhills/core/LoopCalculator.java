package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:19
 */
public class LoopCalculator extends VolumeCalculator {
    @Override
    public int[] calculateArray(int[] hills) {
        int max = 0;
        int index = 0;
        int[] volumes = new int[hills.length];

        int maxLeft = 0;
        int maxRight = 0;
        int indexLeft = 0;
        int indexRight = hills.length - 1;

        while (indexLeft < indexRight) {
            if (hills[indexLeft] > maxLeft) maxLeft = hills[indexLeft];
            if (hills[indexRight] > maxRight) maxRight = hills[indexRight];


            if (maxLeft < maxRight) {
                max = maxLeft;
                index = indexLeft++;
            } else {
                max = maxRight;
                index = indexRight--;
            }

            volumes[index] = max - hills[index];
        }

        return volumes;
    }
}
