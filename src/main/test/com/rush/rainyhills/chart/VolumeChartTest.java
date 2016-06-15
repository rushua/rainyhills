package com.rush.rainyhills.chart;

import org.jfree.graphics2d.svg.SVGUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 0:27
 */
public class VolumeChartTest {

    @Ignore
    @Test
    public void createSVG() {
        try {
            VolumeChart volumeChart = new VolumeChart(new int[]{0, 1, 2, 3, 4}, new int[]{5, 4, 3, 2, 1});
            File file = new File("C:\\volumeChar.svg");
            SVGUtils.writeToSVG(file, volumeChart.getSVGElement());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
