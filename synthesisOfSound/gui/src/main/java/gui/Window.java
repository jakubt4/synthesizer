package gui;

import java.util.logging.Logger;

public class Window {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private final Frame frame;
    private final WindowDimension dimension;

    public Window() {
        dimension = new WindowDimension();
        this.frame = new Frame(dimension);
    }

    public void init() {
        dimension.init();
        frame.init();
        LOG.info("Init of Window was succesful.");
    }

    public void start() {
        frame.setVisible(true);
        LOG.info("Frame is running.");
    }
}
