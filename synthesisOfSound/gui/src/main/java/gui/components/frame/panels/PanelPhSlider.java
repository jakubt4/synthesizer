package gui.components.frame.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.frame.PanelSliderInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class PanelPhSlider extends PanelSliderInterface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;
    private final Components components;

    public PanelPhSlider(Components components) {
        this.components = components;
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            JSlider slider = new JSlider();
            ComponentsUtil.setupSl(slider, 20, 200);
            addListener(slider, i);
            this.add(slider);
            phasesSliders.add(slider);
            LOG.info("Added " + slider.getClass().getSimpleName()
                    + " to panel.");
        }
    }

    @Override
    protected void addListener(final JSlider sl, final int i) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {

                    String value = String.format("%.4g%n",
                            ((double) sl.getValue() / 100) * Math.PI);

                    if (value.charAt(1) == ',') {
                        value = value.replace(',', '.');
                    }
                    phases.get(i).setText(value);
                    ComponentsUtil.doAction(components);
                }
            }
        });
        
        sl.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                setAction(e);
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                setAction(e);
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                setAction(e);
            }

            private void setAction(KeyEvent e) {
                if((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 200){
                    String value = String.format("%.4g%n",
                            ((double) sl.getValue() / 100) * Math.PI);
                    phases.get(i).setText(value);
                    ComponentsUtil.doAction(components);
                }
            }
        });
        LOG.info("Added listener.");
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 375, 40, 235,
                (NUMBER_OF_ELEMENTS.get(0) * 32) + 28 + 40, false);
        return this;
    }

}
