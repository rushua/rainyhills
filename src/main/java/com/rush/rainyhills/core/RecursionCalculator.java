package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:06
 */
public class RecursionCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] emptyHills) {
        return calculate(emptyHills, 0);
    }

    @Override
    public int[] calculateHills(int[] emptyHills) {
        int[] fullHills = new int[emptyHills.length];
        System.arraycopy(emptyHills, 0, fullHills, 0, emptyHills.length);
        calculateHills(emptyHills, fullHills, 0);
        return fullHills;
    }

    private int calculate(int[] hills, int startIndex) {
        int volume = 0;
        if (startIndex < hills.length) {
            int boardHill = hills[startIndex];

            startIndex++;
            int endIndex = findMaxIndex(hills, startIndex);
            if (endIndex < hills.length) {
                boardHill = boardHill < hills[endIndex] ? boardHill : hills[endIndex];
                for (int i = startIndex; i < endIndex; i++) {
                    if (hills[i] > boardHill) {
                        boardHill = hills[i];
                    } else {
                        volume += boardHill - hills[i];
                    }
                }

                startIndex = endIndex;
                volume += calculate(hills, startIndex);
            }
        }
        return volume;
    }

    private int[] calculateHills(int[] emptyHills, int[] fullHills, int startIndex) {
        if (startIndex < emptyHills.length) {
            int maxHill = emptyHills[startIndex];

            startIndex++;
            int endIndex = findMaxIndex(emptyHills, startIndex);
            if (endIndex < emptyHills.length) {
                maxHill = maxHill < emptyHills[endIndex] ? maxHill : emptyHills[endIndex];
                for (int i = startIndex; i < endIndex; i++) {
                    if (emptyHills[i] > maxHill) {
                        maxHill = emptyHills[i];
                    } else {
                        fullHills[i] = maxHill;
                    }
                }

                startIndex = endIndex;
                calculateHills(emptyHills, fullHills, startIndex);
            }
        }
        return fullHills;
    }

    private int findMaxIndex(int[] emptyHills, int startIndex) {
        int maxHill = 0;
        int maxIndex = startIndex;
        for (int i = startIndex; i < emptyHills.length; i++) {
            if (emptyHills[i] > maxHill) {
                maxHill = emptyHills[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
