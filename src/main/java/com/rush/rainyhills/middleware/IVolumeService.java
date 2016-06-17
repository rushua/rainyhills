package com.rush.rainyhills.middleware;

import java.util.List;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:48
 */
public interface IVolumeService {

    public int getVolume(int[] emptyHills);

    public int[] getFullHills(int[] emptyHills);
}
