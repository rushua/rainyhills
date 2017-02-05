package com.rush.rainyhills.core;

import java.util.stream.IntStream;

/**
 * Created by Ruslan Khalikov
 * Date: 06.02.17
 * Time: 0:34
 */
public abstract class VolumeCalculator implements IVolumeCalculator {
    @Override
    public int calculate(int[] hills) {
        return IntStream.of(calculateArray(hills)).sum();
    }
}
