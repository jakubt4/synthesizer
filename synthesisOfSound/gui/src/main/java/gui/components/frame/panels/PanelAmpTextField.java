package gui.components.frame.panels;

import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;

import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAmpTextField extends JPanel implements PanelIntereface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    public PanelAmpTextField() {
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
            ampls.add(tf);
        }
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 270, 40, 35,
                (NUMBER_OF_ELEMENTS.get(0) * 32), false);
        return this;
    }
}
