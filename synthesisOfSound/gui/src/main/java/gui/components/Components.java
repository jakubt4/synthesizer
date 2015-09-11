package gui.components;

import gui.Frame;
import gui.components.frame.AmplPhasesSetUpFrame;
import gui.components.panels.ControllButtonsPanel;
import gui.components.panels.FrekvPanel;
import gui.components.panels.GraphPanel;
import gui.components.panels.SettingButtonsPanel;
import gui.components.panels.TitleAndSetForNumberOfElements;

import java.awt.Container;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JTextField;

import plotGraph.PlotGraph;

public class Components implements ElementsChangesListener {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private final Container container;

    private TitleAndSetForNumberOfElements title;
    private GraphPanel graphPanel;
    private FrekvPanel frekvPanel;
    private PlotGraph plotGraph;
    private SettingButtonsPanel settingButtonsPanel;
    private ControllButtonsPanel controllPanel;
    private Frame frame;

    public Components(Container container) {
        this.container = container;
        container.setLayout(null);
    }

    public void init(Frame frame) {

        NUMBER_OF_ELEMENTS.add(0, 7);

        this.frame = frame;
        title = new TitleAndSetForNumberOfElements(this);
        create(title);

        AmplPhasesSetUpFrame amplFrame = new AmplPhasesSetUpFrame(this);
        amplFrame.init();
        amplFrame.createComponentsForFrame();

        frekvPanel = new FrekvPanel(this);
        create(frekvPanel);
        setFrekv();

        plotGraph = new PlotGraph();
        plotGraph.setAll(getDoubles(ampls), getDoubles(phases), frekv.get(0));
        plotGraph.init();

        graphPanel = new GraphPanel(plotGraph.createChart());
        create(graphPanel);

        settingButtonsPanel = new SettingButtonsPanel(this);
        create(settingButtonsPanel);

        controllPanel = new ControllButtonsPanel();
        create(controllPanel);

        LOG.info("Init of " + this.getClass().getSimpleName()
                + " was succesful.");
    }

    public double[] getDoubles(ArrayList<JTextField> values) {
        double[] doubles = new double[values.size()];
        int i = 0;
        for (JTextField value : values) {
            doubles[i] = Double.parseDouble(value.getText());
            i++;
        }
        return doubles;
    }

    public <T extends PanelIntereface> void create(T panel) {
        panel.createComponentsForPanel();
        try {
            if (container.add(panel.getPanel()) != null) {
                LOG.info("Adding " + panel.getClass().getSimpleName()
                        + " done.");
            }

        } catch (NullPointerException e) {
            LOG.warning("Failed to add " + panel.getClass().getSimpleName()
                    + " to container - " + e.toString());
        }
    }

    public Frame getFrame() {
        return frame;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }

    public void setGraphPanel(GraphPanel graphPanel2) {
        graphPanel = graphPanel2;
    }

    public void setFrekv() {
        frekvPanel.setFrekv();
    }
}
