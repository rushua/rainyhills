package com.rush.rainyhills.ejb;

import com.rush.rainyhills.util.VolumeCalculatorUtil;

import javax.ejb.Stateless;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:41
 */
@Stateless
public class VolumeCalculator implements IVolumeCalculator {

    @Override
    public int getVolume(int[] hills) {
        return VolumeCalculatorUtil.calculate(hills);
    }
}
