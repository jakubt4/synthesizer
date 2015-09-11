package gui.components.frame;

import gui.components.Components;
import gui.components.ElementsChangesListener;
import gui.components.frame.core.CoreOfFrame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class AmplPhasesSetUpFrame extends JFrame implements ElementsChangesListener, FrameListener {

    private static final long serialVersionUID = 1L;

    // private PanelAmpTextField panelAmpTextField;
    // private PanelAmplSlider panelAmplSlider;
    // private final Components components;
    // // private final Container container;
    //
    // private PanelPhSlider panelPhSlider;
    //
    // private PanelPhTextField panelPhTextField;
    //
    // private JLabel label;
    //
    // private final Point startLoc = null;
    //
    // private LabelPanel labelPanel;

    private final JPanel mainPanel;
    private final CoreOfFrame coreOfFrame;

    public AmplPhasesSetUpFrame(Components components) {
        // this.components = components;
        // container = this.getContentPane();
        // container.setLayout(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        coreOfFrame = new CoreOfFrame(mainPanel, components);
    }

    public void init() {
        this.setTitle("Amplitudes and phases");
        coreOfFrame.init();

        // label = new JLabel("Amplitudes");
        // label.setBounds(110, 10, 80, 30);
        // container.add(label);
        //
        // labelPanel = new LabelPanel(20);
        // labelPanel.createComponentsForPanel();
        // container.add(labelPanel.getPanel());
        //
        // panelAmpTextField = new PanelAmpTextField();
        // panelAmpTextField.createComponentsForPanel();
        // panelAmplSlider = new PanelAmplSlider(components);
        // panelAmplSlider.createComponentsForPanel();
        //
        // label = new JLabel("Phases");
        // label.setBounds(450, 10, 80, 30);
        // container.add(label);
        //
        // labelPanel = new LabelPanel(360);
        // labelPanel.createComponentsForPanel();
        // container.add(labelPanel.getPanel());
        //
        // panelPhTextField = new PanelPhTextField();
        // panelPhTextField.createComponentsForPanel();
        // panelPhSlider = new PanelPhSlider(components);
        // panelPhSlider.createComponentsForPanel();
        // amplPhasesSetUpFrames.add(this);
        
    }



    public void createComponentsForFrame() {
//        this.setSize(700, (panelAmplSlider.getPanel().getHeight()) + 10);
        this.setSize(660, 320);

        // container.add(panelAmplSlider.getPanel());
        // container.add(panelAmpTextField.getPanel());
        //
        // container.add(panelPhSlider.getPanel());
        // container.add(panelPhTextField.getPanel());

        amplPhasesSetUpFrames.add(this);

        // set up scroller
        JScrollPane scrollFrame = new JScrollPane(mainPanel);
        mainPanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(660, 320));
        scrollFrame.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollFrame);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        frames.add(this);
    }
}
