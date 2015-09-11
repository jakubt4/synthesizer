package gui;

import gui.components.Components;

import java.util.logging.Logger;

import javax.swing.JFrame;

public class Frame extends JFrame {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    private final WindowDimension dimension;
    private final Components components;
    private final boolean resizableOfWindow = false;

    public Frame(WindowDimension dimension) {
        this.dimension = dimension;
        components = new Components(this.getContentPane());
    }

    public void init() {
        this.setTitle("Synthesis Of Tone");
        this.setBounds(dimension.getX(), dimension.getY(),
                920, 710);
        this.setResizable(this.resizableOfWindow);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        components.init(this);
        LOG.info("Init of Frame was succesful.");
    }
}
