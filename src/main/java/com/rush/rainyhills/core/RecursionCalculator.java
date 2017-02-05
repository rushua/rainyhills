package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:06
 */
public class RecursionCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] emptyHills) {
        return calculate(0, maxHillIndex(1, emptyHills), emptyHills);
    }

    @Override
    public int[] calculateHills(int[] emptyHills) {
        int[] fullHills = new int[emptyHills.length];
        System.arraycopy(emptyHills, 0, fullHills, 0, emptyHills.length);
        calculateHills(0, maxHillIndex(1, emptyHills), emptyHills, fullHills);
        return fullHills;
    }

    private int calculate(int startIndex, int endIndex, int[] emptyHills) {
        int volume = 0;
        if (endIndex < emptyHills.length) {
            int blockHill = Math.min(emptyHills[startIndex], emptyHills[endIndex]);

            startIndex = startIndex + 1;
            for (int i = startIndex; i < endIndex; i++) {
                if (emptyHills[i] > blockHill) {
                    blockHill = emptyHills[i];
                } else {
                    volume += blockHill - emptyHills[i];
                }
            }

            startIndex = endIndex;
            endIndex = maxHillIndex(startIndex + 1, emptyHills);
            volume += calculate(startIndex, endIndex, emptyHills);
        }
        return volume;
    }

    private int[] calculateHills(int startIndex, int endIndex, int[] emptyHills, int[] fullHills) {
        if (endIndex < emptyHills.length) {
            int blockHill = Math.min(emptyHills[startIndex], emptyHills[endIndex]);

            startIndex = startIndex + 1;
            for (int i = startIndex; i < endIndex; i++) {
                if (emptyHills[i] > blockHill) {
                    blockHill = emptyHills[i];
                } else {
                    fullHills[i] = blockHill;
                }
            }

            startIndex = endIndex;
            endIndex = maxHillIndex(startIndex + 1, emptyHills);
            calculateHills(startIndex, endIndex, emptyHills, fullHills);
        }
        return fullHills;
    }

    private int maxHillIndex(int startIndex, int[] emptyHills) {
        int maxHill = 0;
        int maxHillIndex = startIndex;
        for (int i = startIndex; i < emptyHills.length; i++) {
            if (emptyHills[i] > maxHill) {
                maxHill = emptyHills[i];
                maxHillIndex = i;
            }
        }
        return maxHillIndex;
    }
}
