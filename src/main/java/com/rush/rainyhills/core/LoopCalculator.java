package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:19
 */
public class LoopCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] emptyHills) {
        int volume = 0;

        int maxLeft = 0;
        int maxRight = 0;
        int indexLeft = 0;
        int indexRight = emptyHills.length - 1;

        while (indexLeft < indexRight) {
            if (emptyHills[indexLeft] > maxLeft) maxLeft = emptyHills[indexLeft];
            if (emptyHills[indexRight] > maxRight) maxRight = emptyHills[indexRight];

            volume += maxLeft < maxRight ? maxLeft - emptyHills[indexLeft++] : maxRight - emptyHills[indexRight--];
        }

        return volume;
    }

    @Override
    public int[] calculateHills(int[] emptyHills) {
        int[] fullHills = new int[emptyHills.length];
        System.arraycopy(emptyHills, 0, fullHills, 0, emptyHills.length);

        int maxLeft = 0;
        int maxRight = 0;
        int indexLeft = 0;
        int indexRight = emptyHills.length - 1;

        while (indexLeft < indexRight) {
            if (emptyHills[indexLeft] > maxLeft) maxLeft = emptyHills[indexLeft];
            if (emptyHills[indexRight] > maxRight) maxRight = emptyHills[indexRight];

            if (maxLeft < maxRight) fullHills[indexLeft++] = maxLeft;
            else fullHills[indexRight--] = maxRight;
        }

        return fullHills;
    }
}
