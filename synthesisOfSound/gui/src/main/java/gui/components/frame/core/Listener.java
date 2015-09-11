package gui.components.frame.core;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.ElementsChangesListener;
import gui.components.frame.FrameListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JSlider;

public class Listener implements ElementsChangesListener, FrameListener {

    protected void addListener(final JSlider sl, final int i, final Components components) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {

                    String value = String.format("%.4g%n", ((double) sl.getValue() / 100) * Math.PI);

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
                if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 200) {
                    String value = String.format("%.4g%n", ((double) sl.getValue() / 100) * Math.PI);
                    phases.get(i).setText(value);
                    ComponentsUtil.doAction(components);
                }
            }
        });
    }

    protected void addListenerAmpl(final JSlider sl, final int i, final Components components) {
        sl.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent evt) {
                sliderMouseDragged(evt);
            }

            private void sliderMouseDragged(MouseEvent evt) {
                if (frekv.get(0) == 0) {
                    ComponentsUtil.warning("Frekvency should not be null !!");
                } else {
                    ampls.get(i).setText(String.valueOf((double) sl.getValue() / 100));
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
                if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) && sl.getValue() <= 100) {
                    ampls.get(i).setText(String.valueOf((double) sl.getValue() / 100));
                    ComponentsUtil.doAction(components);
                }
            }
        });
    }
}
