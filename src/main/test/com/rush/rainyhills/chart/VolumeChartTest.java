package com.rush.rainyhills.chart;

import com.rush.rainyhills.TestItemUtil;
import org.jfree.graphics2d.svg.SVGUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static com.rush.rainyhills.TestItemUtil.volumes;

/**
 * Created by Ruslan Khalikov
 * Date: 16.06.2016
 * Time: 0:27
 */
public class VolumeChartTest {
    TestItemUtil.TestItem item;

    @Before
    public void init() {
        item = TestItemUtil.createTestItems()[28];
    }

    @Test
    public void createEmptySVG() {
        try {
            VolumeChart volumeChart = new VolumeChart(item.getEmptyHills());
            Assert.assertEquals("", volumeChart.getVolume());
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
                    item.getEmptyHills(),
                    volumes(item.getEmptyHills(), item.getFullHills()));
            Assert.assertEquals(String.valueOf(item.getVolume()), volumeChart.getVolume());
            File file = File.createTempFile("chart", ".svg");
            SVGUtils.writeToSVG(file, volumeChart.getSVGElement());
            file.deleteOnExit();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
