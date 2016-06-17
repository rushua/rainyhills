package com.rush.rainyhills.chart;

import org.jfree.graphics2d.svg.SVGUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 0:27
 */
public class VolumeChartTest {

    @Test
    public void createEmptySVG() {
        try {
            VolumeChart volumeChart = new VolumeChart(new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6});
            File file = File.createTempFile("chart", ".svg");
            SVGUtils.writeToSVG(file, volumeChart.getSVGElement());
            file.deleteOnExit();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void createFullSVG() {
        try {
            VolumeChart volumeChart = new VolumeChart(
                    new int[]{2, 5, 1, 2, 3, 4, 7, 7, 6},
                    new int[]{2, 5, 5, 5, 5, 5, 7, 7, 6});
            File file = File.createTempFile("chart", ".svg");
            SVGUtils.writeToSVG(file, volumeChart.getSVGElement());
            file.deleteOnExit();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
