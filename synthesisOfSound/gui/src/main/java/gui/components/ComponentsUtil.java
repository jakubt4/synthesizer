package gui.components;

import gui.components.panels.GraphPanel;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import plotGraph.PlotGraph;

public class ComponentsUtil implements ElementsChangesListener {

    private static PlotGraph plotGraph;
    private static GraphPanel graphPanel;

    private ComponentsUtil() {

    }

    public static void doAction(Components components) {
        components.getFrame().remove(components.getGraphPanel());
        components.getFrame().repaint();

        components.setFrekv();

        plotGraph = new PlotGraph();
        plotGraph.setAll(components.getDoubles(ampls),
                components.getDoubles(phases), frekv.get(0));
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());

        components.getFrame().add(graphPanel.getPanel());
        components.getFrame().repaint();
        components.setGraphPanel(graphPanel);
    }

    public static void warning(String warningMessage) {
        JOptionPane.showMessageDialog(new JFrame(), warningMessage, "WARNING",
                JOptionPane.WARNING_MESSAGE);
    }

    public static void setupSl(JSlider sl, int minorTickSpacing, int maximum) {
        sl.setMaximum(maximum);
        sl.setMinorTickSpacing(minorTickSpacing);
        sl.setPaintLabels(true);
        sl.setPaintTicks(true);
        sl.setValue(0);
    }

    public static void setPanelSettings(JPanel panel, int x, int y, int width,
            int height, boolean useBorder) {
        panel.setBounds(x, y, width, height);
        if (useBorder) {
            panel.setBorder(BorderFactory.createBevelBorder(0));
        }
    }
}