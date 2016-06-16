package com.rush.rainyhills.core;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 20:06
 */
public class RecursionCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] hills) {
        return calculate(hills, 0);
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

    private int findMaxIndex(int[] hills, int startIndex) {
        int maxHill = 0;
        int maxIndex = startIndex;
        for (int i = startIndex; i < hills.length; i++) {
            if (hills[i] > maxHill) {
                maxHill = hills[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
