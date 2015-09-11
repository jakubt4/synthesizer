package gui.components.panels;

import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JPanel;

import sound.PlaySound;

public class ControllButtonsPanel extends JPanel implements PanelIntereface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;


    protected static boolean listenerOnStop = true;
    protected JButton stop;
    protected JButton start;
    
    public ControllButtonsPanel() {
        this.setLayout(null);
    }

    @Override
    public void createComponentsForPanel() {
        start = new JButton("Start");
        start.setBounds(0, 0, 100, 35);
        addListener(start);
        this.add(start);

        stop = new JButton("Stop");
        stop.setBounds(150, 0, 100, 35);
        stop.setEnabled(false);
        addListener(stop);
        this.add(stop);

        LOG.info("Buttons added to panel.");
    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 610, 530, 400, 35, false);
        return this;
    }
    
    private void addListener(final JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mouseClicked(e);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            private void mouseClicked(ActionEvent e) throws InterruptedException {
                Thread thread = new Thread(new PlayLoop());
                switch(button.getText()){
                    case "Start":
                        start.setEnabled(false);
                        stop.setEnabled(true);
                        listenerOnStop = true;
                        thread.start();
                        break;
                    case "Stop":
                        start.setEnabled(true);
                        stop.setEnabled(false);
                        listenerOnStop  = false;
                        thread.join();
                        thread.interrupt();
                        break;
                }
            }
        });

        LOG.info("Added listener");
    }

    private static class PlayLoop implements Runnable{
        
        @Override
        public void run() {
            try {
                while(listenerOnStop){
                    PlaySound playSound = new PlaySound();
                    playSound.play();
                }
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }

}
