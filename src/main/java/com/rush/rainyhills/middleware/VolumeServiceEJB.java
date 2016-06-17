package com.rush.rainyhills.middleware;

import com.rush.rainyhills.core.RecursionCalculator;
import com.rush.rainyhills.core.VolumeCalculator;

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
    private VolumeCalculator volumeCalculator;

    @PostConstruct
    public void init() {
        volumeCalculator.setVolumeCalculator(new RecursionCalculator());
    }

    @Override
    public int getVolume(int[] emptyHill) {
        return volumeCalculator.calculate(emptyHill);
    }

    @Override
    public int[] getFullHills(int[] emptyHills) {
        return volumeCalculator.calculateHills(emptyHills);
    }
}
