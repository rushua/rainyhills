package com.rush.rainyhills.core;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 23:03
 */
@ApplicationScoped
public class VolumeCalculator implements IVolumeCalculator {

    private IVolumeCalculator volumeCalculator;

    public void setVolumeCalculator(IVolumeCalculator volumeCalculator) {
        this.volumeCalculator = volumeCalculator;
    }

    @Override
    public int calculate(int[] emptyHills) {
        return volumeCalculator.calculate(emptyHills);
    }

    @Override
    public int[] calculateHills(int[] emptyHills) {
        return volumeCalculator.calculateHills(emptyHills);
    }
}
