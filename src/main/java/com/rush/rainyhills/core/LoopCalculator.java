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

        int maxL = 0;
        int maxR = 0;
        int indexL = 0;
        int indexR = hills.length - 1;

        while (indexL < indexR) {
            if (hills[indexL] > maxL) maxL = hills[indexL];
            if (hills[indexR] > maxR) maxR = hills[indexR];

            volume += maxL < maxR ? maxL - hills[indexL++] : maxR - hills[indexR--];
        }

        return volume;
    }
}
