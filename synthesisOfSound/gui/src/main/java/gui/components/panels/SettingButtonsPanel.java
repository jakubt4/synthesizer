package gui.components.panels;

import gui.components.Components;
import gui.components.ComponentsUtil;
import gui.components.PanelIntereface;
import gui.components.TypesOfActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingButtonsPanel extends JPanel implements PanelIntereface {

    private final Logger LOG = Logger
            .getLogger(this.getClass().getSimpleName());

    private static final long serialVersionUID = 1L;

    private final Components components;

    public SettingButtonsPanel(Components components) {
        this.components = components;
        this.setLayout(null);

    }

    @Override
    public void createComponentsForPanel() {
        JButton toneA = new JButton("Tone A");
        toneA.setBounds(20, 10, 100, 30);
        addListener(toneA);
        this.add(toneA);

        JButton random = new JButton("Random");
        random.setBounds(140, 10, 100, 30);
        addListener(random);
        this.add(random);

        JButton clean = new JButton("Clean");
        clean.setBounds(260, 10, 100, 30);
        addListener(clean);
        this.add(clean);
        
        LOG.info("Buttons added to panel.");
    }

    private void addListener(JButton button) {
        TypesOfActions typesOfActions;
        switch (button.getText()) {
            case "Clean":
                typesOfActions = TypesOfActions.CLEAN;
                callAction(button, typesOfActions);
                break;
            case "Tone A":
                typesOfActions = TypesOfActions.TONE_A;
                callAction(button, typesOfActions);
                break;
            case "Random":
                typesOfActions = TypesOfActions.RANDOM;
                callAction(button, typesOfActions);
                break;
            default:
                break;
        }
    }

    private void callAction(JButton button, final TypesOfActions typesOfActions) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                switch (typesOfActions) {
                    case CLEAN:
                        setAllElementsOnNull(0);
                        frekv.set(0, 0);
                        frekvTF.get(0).setText("0");
                        break;
                    case TONE_A:
                        setElementsForToneA();
                        frekv.set(0, 440);
                        frekvTF.get(0).setText("440");
                        break;
                    case RANDOM:
                        frekv.set(0, generate(10000));
                        setAllElementsRandom();
                        frekvTF.get(0).setText(frekv.get(0).toString());
                    default:
                        break;
                }

                ComponentsUtil.doAction(components);
            }
        });
    }

    protected void setAllElementsRandom() {
        for(int i = 0; i < phases.size(); i++){
            double amplitude = (double)(generate(100))/100;
            double phase = (double) (generate(200)) / 100;

            String value = String.format("%.4g%n", phase * Math.PI);

            if (value.charAt(1) == ',') {
                value = value.replace(',', '.');
            }

            phases.get(i).setText(value);
            ampls.get(i).setText(String.valueOf(amplitude));
            phasesSliders.get(i).setValue((int) (phase*100));
            amplsSliders.get(i).setValue((int) (amplitude*100));
        }
    }

    protected Integer generate(int up) {
        Random rand = new Random();
        return rand.nextInt(up) + 1;
    }

    protected void setElementsForToneA() {
        phases.get(0).setText("0.0");
        ampls.get(0).setText("1.0");
        phasesSliders.get(0).setValue(0);
        amplsSliders.get(0).setValue(100);
        setAllElementsOnNull(1);
    }

    protected void setAllElementsOnNull(int start) {
        for (int i = start; i < phases.size(); i++) {
            phases.get(i).setText("0.0");
            ampls.get(i).setText("0.0");
            phasesSliders.get(i).setValue(0);
            amplsSliders.get(i).setValue(0);
        }

    }

    @Override
    public JPanel getPanel() {
        ComponentsUtil.setPanelSettings(this, 60, 600, 382, 50, true);
        return this;
    }
}
