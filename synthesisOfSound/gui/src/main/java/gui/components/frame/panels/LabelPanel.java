package gui.components.frame.panels;

import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPanel extends JPanel implements PanelIntereface {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private final int X;

    public LabelPanel(int X) {
        this.X = X;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            label = new JLabel((i + 1) + ".");
            this.add(Box.createVerticalStrut(17));
            this.add(label);
        }
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, X, 27, 30,
                (NUMBER_OF_ELEMENTS.get(0) * 34), false);
        return this;
    }

}
