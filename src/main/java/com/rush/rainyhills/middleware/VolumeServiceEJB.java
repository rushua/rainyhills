package com.rush.rainyhills.middleware;

import com.rush.rainyhills.core.FastCalculator;
import com.rush.rainyhills.core.VolumeCalculator;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

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
        volumeCalculator.setVolumeCalculator(new FastCalculator());
    }

    @Override
    public Integer getVolume(List<Integer> hillList) {
        int[] hills = hillList.stream().mapToInt(hill -> hill).toArray();
        return volumeCalculator.calculate(hills);
    }
}
