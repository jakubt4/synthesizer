package gui.components.frame.core;

import gui.components.Components;
import gui.components.ComponentsUtil;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class CoreOfFrame extends Listener {

    private final JPanel mainPanel;
    private final Components components;
    
    public CoreOfFrame(JPanel mainPanel, Components components) {
        this.mainPanel = mainPanel;
        this.components = components;
    }

    public void init() {
        JTextField tf;
        JSlider slider;
        JPanel panel;
        JLabel label;
        mainPanel.setPreferredSize(new Dimension(650, (NUMBER_OF_ELEMENTS.get(0) + 1) * 37));
    
        panel = new JPanel(null);
        panel.setSize(650, 37);
        label = new JLabel("Amplitudes");
        label.setBounds(50, 1, 200, 35);
        panel.add(label);

        label = new JLabel("Phases");
        label.setBounds(350, 1, 200, 35);
        panel.add(label);

        panel.setBounds(0, 0, 650, 37);
        mainPanel.add(panel);
    
        for (int i = 0; i < NUMBER_OF_ELEMENTS.get(0); i++) {
            panel = new JPanel(null);
            panel.setSize(650, 37);

            // label
            label = new JLabel(String.valueOf(i + 1) + ".");
            label.setBounds(15, 1, 30, 20);
            panel.add(label);

        // slider ampl
            slider = new JSlider();
            ComponentsUtil.setupSl(slider, 10, 100);
            slider.setBounds(50, 1, 200, 35);
            addListenerAmpl(slider, i, components);
            panel.add(slider);
            amplsSliders.add(slider);

        // tf ampl
            tf = new JTextField();
            tf.setText("0.0");
            tf.setEditable(false);
            tf.setBounds(255, 1, 50, 25);
            panel.add(tf);
            ampls.add(tf);

            label = new JLabel(String.valueOf(i + 1) + ".");
            label.setBounds(350, 1, 30, 20);
            panel.add(label);

        // slider ph
            slider = new JSlider();
            ComponentsUtil.setupSl(slider, 20, 200);
            slider.setBounds(385, 1, 200, 35);
            addListener(slider, i, components);
            panel.add(slider);
            phasesSliders.add(slider);

        // tf ph
        tf = new JTextField();
        tf.setText("0.0");
        tf.setEditable(false);
        tf.setBounds(590, 1, 50, 25);
        panel.add(tf);
        phases.add(tf);

        panel.setBounds(0, (i + 1) * 37, 700, 37);

        mainPanel.add(panel);
    }
    }
}
