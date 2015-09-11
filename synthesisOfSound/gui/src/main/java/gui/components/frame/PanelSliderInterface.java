package gui.components.frame;

import gui.components.PanelIntereface;

import javax.swing.JPanel;
import javax.swing.JSlider;

public abstract class PanelSliderInterface extends JPanel implements
        PanelIntereface {

    private static final long serialVersionUID = 1L;

    protected abstract void addListener(final JSlider slider, final int i);
}
