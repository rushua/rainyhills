package com.rush.rainyhills.middleware;

import com.rush.rainyhills.core.IVolumeCalculator;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 23:03
 */
@ApplicationScoped
public class WaterCalculator implements IVolumeCalculator {

    private IVolumeCalculator volumeCalculator;

    public void setVolumeCalculator(IVolumeCalculator volumeCalculator) {
        this.volumeCalculator = volumeCalculator;
    }

    @Override
    public int calculate(int[] hills) {
        return volumeCalculator.calculate(hills);
    }

    @Override
    public int[] calculateArray(int[] hills) {
        return volumeCalculator.calculateArray(hills);
    }
}
