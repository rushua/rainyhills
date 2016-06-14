package com.rush.rainyhills;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 14:19
 */
public abstract class VolumeCalculator {

    public static int calculate(int[] flasks) {
        int volume = 0;

        int indexL = 0;
        int indexR = flasks.length - 1;
        int maxL = flasks[indexL];
        int maxR = flasks[indexR];

        while (indexL < indexR) {
            if (flasks[indexL] > maxL) maxL = flasks[indexL];
            if (flasks[indexR] > maxR) maxR = flasks[indexR];

            volume += maxL < maxR ? maxL - flasks[indexL++] : maxR - flasks[indexR--];
        }

        return volume;
    }
}
