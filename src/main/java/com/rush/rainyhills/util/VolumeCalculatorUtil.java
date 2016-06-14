package com.rush.rainyhills.util;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:19
 */
public abstract class VolumeCalculatorUtil {

    public static int calculate(int[] hills) {
        int volume = 0;

        int indexL = 0;
        int indexR = hills.length - 1;
        int maxL = hills[indexL];
        int maxR = hills[indexR];

        while (indexL < indexR) {
            if (hills[indexL] > maxL) maxL = hills[indexL];
            if (hills[indexR] > maxR) maxR = hills[indexR];

            volume += maxL < maxR ? maxL - hills[indexL++] : maxR - hills[indexR--];
        }

        return volume;
    }
}
