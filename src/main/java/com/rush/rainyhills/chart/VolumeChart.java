package com.rush.rainyhills.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.graphics2d.svg.SVGGraphics2D;

import java.awt.*;

/**
 * Created by Ruslan Khalikov
 * Date: 15.06.2016
 * Time: 23:50
 */
public class VolumeChart {
    private static final Color BROWN = new Color(150, 75, 0);
    private static final Color BROWN_DARK = new Color(75, 0, 0);
    private static final Color BLUE = new Color(0, 0, 255);
    private static final Color BLUE_DARK = new Color(0, 0, 64);
    private static final Point CHAR_SIZE = new Point(1000, 700);
    private static final String TITLE = "VOLUME";

    private JFreeChart volumeChart;

    public VolumeChart(int[] emptyHills) {
        volumeChart = ChartFactory.createHistogram(
                "", "HILL", "HIGH", buildDataset(emptyHills, new int[]{}),
                PlotOrientation.VERTICAL, false, false, false);
        initChart();
    }

    public VolumeChart(int[] emptyHills, int[] fullHills) {
        volumeChart = ChartFactory.createHistogram(
                TITLE + " = " + buildVolume(emptyHills, fullHills),
                "HILL", "HIGH", buildDataset(emptyHills, fullHills),
                PlotOrientation.VERTICAL, false, false, false);
        initChart();
    }

    public String getSVGDocument() {
        SVGGraphics2D svgGraphics2D = new SVGGraphics2D(CHAR_SIZE.x, CHAR_SIZE.y);
        Rectangle rectangle = new Rectangle(0, 0, CHAR_SIZE.x, CHAR_SIZE.y);
        volumeChart.draw(svgGraphics2D, rectangle);
        return svgGraphics2D.getSVGDocument();
    }

    public String getSVGElement() {
        SVGGraphics2D svgGraphics2D = new SVGGraphics2D(CHAR_SIZE.x, CHAR_SIZE.y);
        Rectangle rectangle = new Rectangle(0, 0, CHAR_SIZE.x, CHAR_SIZE.y);
        volumeChart.draw(svgGraphics2D, rectangle);
        return svgGraphics2D.getSVGElement();
    }

    public String getVolume() {
        return volumeChart.getTitle().getText().replaceAll(TITLE + " = ", "");
    }

    private IntervalXYDataset buildDataset(int[] emptyHills, int[] fullHills) {
        XYSeries emptySeries = new XYSeries("empty");
        for (int i = 0; i < emptyHills.length; i++) {
            emptySeries.add(i, emptyHills[i]);
        }
        XYSeries fullSeries = new XYSeries("full");
        for (int i = 0; i < fullHills.length; i++) {
            fullSeries.add(i, fullHills[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(emptySeries);
        dataset.addSeries(fullSeries);
        return dataset;
    }

    private int buildVolume(int[] emptyHills, int[] fullHills) {
        int volume = 0;
        for (int i = 0; i < emptyHills.length; i++) {
            volume += fullHills[i] - emptyHills[i];
        }
        return volume;
    }

    private void initChart() {
        XYPlot plot = volumeChart.getXYPlot();

        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.setDomainZeroBaselineVisible(false);
        plot.setRangeZeroBaselineVisible(false);

        ChartUtilities.applyCurrentTheme(volumeChart);

        XYItemRenderer renderer = new XYBarRenderer();
        renderer.setSeriesVisibleInLegend(0, false);
        renderer.setSeriesVisibleInLegend(1, false);

        renderer.setSeriesPaint(0, new GradientPaint(0.0f, 0.0f, BROWN, 0.0f, 0.0f, BROWN_DARK));
        renderer.setSeriesPaint(1, new GradientPaint(0.0f, 0.0f, BLUE, 0.0f, 0.0f, BLUE_DARK));
        plot.setRenderer(renderer);
    }
}
