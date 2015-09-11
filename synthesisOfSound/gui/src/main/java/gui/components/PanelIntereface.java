package gui.components;

import javax.swing.JPanel;

public interface PanelIntereface extends ElementsChangesListener {

    public void createComponentsForPanel();

    public JPanel getPanel();
}
