package com.rush.rainyhills.middleware;

import com.rush.rainyhills.core.LoopCalculator;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:41
 */
@Stateless
public class VolumeServiceEJB implements IVolumeService {
    @Inject
    private WaterCalculator waterCalculator;

    @PostConstruct
    public void init() {
        waterCalculator.setVolumeCalculator(new LoopCalculator());
    }

    @Override
    public int getVolume(int[] hills) {
        return waterCalculator.calculate(hills);
    }

    @Override
    public int[] getVolumes(int[] hills) {
        return waterCalculator.calculateArray(hills);
    }
}
