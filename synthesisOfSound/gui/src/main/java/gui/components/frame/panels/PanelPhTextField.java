package gui.components.frame.panels;

import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;

import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPhTextField extends JPanel implements PanelIntereface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    public PanelPhTextField() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            JTextField tf = new JTextField();
            tf.setText("0.0");
            tf.setEditable(false);
            this.add(tf);
            LOG.info("Added " + tf.getClass().getSimpleName() + " to panel.");
            phases.add(tf);
        }
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 610, 40, 60,
                (NUMBER_OF_ELEMENTS.get(0) * 32), false);
        return this;
    }
}
