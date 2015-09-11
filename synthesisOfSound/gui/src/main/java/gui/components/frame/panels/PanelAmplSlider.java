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

public class PanelAmplSlider extends PanelSliderInterface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;
    private final Components components;

    public PanelAmplSlider(Components components) {
        this.components = components;
    }

    @Override
    public void createComponentsForPanel() {
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            JSlider slider = new JSlider();
            ComponentsUtil.setupSl(slider, 10, 100);
            addListener(slider, i);
            this.add(slider);
            amplsSliders.add(slider);
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
                    ampls.get(i).setText(
                            String.valueOf((double) sl.getValue() / 100));
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
                if((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 100){
                    ampls.get(i).setText(
                            String.valueOf((double) sl.getValue() / 100));
                    ComponentsUtil.doAction(components);
                }
            }
        });
        LOG.info("Added listener");
    }

    @Override
    public JPanel getPanel() {
        // ComponentsUtil.setPanelSettings(this, 850, 50, 250, 229, true);
        ComponentsUtil.setPanelSettings(this, 30, 40, 240,
                (NUMBER_OF_ELEMENTS.get(0) * 34) + 28 + 40, false);
        return this;
    }

}
