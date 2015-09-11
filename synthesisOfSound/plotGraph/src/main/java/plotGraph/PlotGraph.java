package plotGraph;

import java.awt.Color;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PlotGraph {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private int frekv;
    private double[] ampls;
    private double[] phases;

    XYDataset xyDataset;

    public void setAll(double[] ampls, double[] phases, int frekv) {
        this.ampls = ampls;
        this.phases = phases;
        this.frekv = frekv;
    }

    public void init() {
        xyDataset = createDataSet();
        LOG.info("Dataset created.");

    }

    private XYDataset createDataSet() {
        double sinus = 0;
        double y = 0;
        double val = (1 / (double) frekv) / 360;
        XYSeries sinSeries = new XYSeries("");

        for (double x = 0.0; x < 361; x += 1) {
            sinus = 0;
            for (int i = 0; i < ampls.length; i++) {
                sinus += (ampls[i] * Math.sin((x / (180 / (i + 1))) * Math.PI
                        + (phases[i])));
            }
            y += val;
            sinSeries.add(y, sinus);
        }
        XYSeriesCollection seriesCollection = new XYSeriesCollection();
        seriesCollection.addSeries(sinSeries);
        return seriesCollection;
    }

    public JFreeChart createChart() {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("", "t(s)", "",
                xyDataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);

        XYPlot xyplot = (XYPlot) jfreechart.getPlot();

        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        LOG.info("JFreeChart setted.");
        return jfreechart;
    }
}
