package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Logger;

public class WindowDimension {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private final Toolkit toolkit;
    private final Dimension dimension;

    private int WIDTH;
    private int HEIGHT;
    private final double constantForWindSize = 1.5;

    private int X;
    private int Y;
    private final int constantForWindPlace = 8;

    public WindowDimension() {
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
    }

    public int getDimensionX() {
        return dimension.width;
    }

    public int getDimensionY() {
        return this.dimension.height;
    }

    public void init() {
        WIDTH = (int) (getDimensionX() / this.constantForWindSize);
        HEIGHT = (int) (getDimensionY() / this.constantForWindSize);
        X = getDimensionX() / this.constantForWindPlace;
        Y = getDimensionY() / this.constantForWindPlace;

        LOG.info("WindowDimension init was succesful.");
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
