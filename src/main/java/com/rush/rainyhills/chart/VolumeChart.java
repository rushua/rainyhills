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
    private JFreeChart volumeChart;

    public VolumeChart(int[] emptyHills, int[] fullHills) {
        volumeChart = ChartFactory.createHistogram(
                "Volume", "Hill", "High", buildDataset(emptyHills, fullHills),
                PlotOrientation.VERTICAL, false, false, false);
        initChart();
    }

    public String getSVGDocument() {
        SVGGraphics2D svgGraphics2D = new SVGGraphics2D(1000, 700);
        Rectangle rectangle = new Rectangle(0, 0, 1000, 700);
        volumeChart.draw(svgGraphics2D, rectangle);
        return svgGraphics2D.getSVGDocument();
    }

    public String getSVGElement() {
        SVGGraphics2D svgGraphics2D = new SVGGraphics2D(1000, 700);
        Rectangle rectangle = new Rectangle(0, 0, 1000, 700);
        volumeChart.draw(svgGraphics2D, rectangle);
        return svgGraphics2D.getSVGElement();
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
//        renderer.setSeriesPaint(0, Color.RED);
//        renderer.setSeriesPaint(1, Color.BLUE);
        GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.BLUE,
                0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.RED,
                0.0f, 0.0f, new Color(64, 0, 0));
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        plot.setRenderer(renderer);
    }
}
