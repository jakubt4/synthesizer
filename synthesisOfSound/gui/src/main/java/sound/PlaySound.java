package sound;

import gui.components.AbstractListenerElements;

import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JTextField;

public class PlaySound extends AbstractListenerElements {
    private double[] amplitudy;
    private double[] fazy;

    public float SAMPLE_RATE = 150000;
    private int hzs;

    public void sound(int msecs) throws LineUnavailableException {
        byte[] buf = new byte[(int) SAMPLE_RATE * msecs / 1000];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = 0;
            for (int j = 0; j < amplitudy.length; j++) {
                buf[i] += (byte) ((127.0 * amplitudy[j] * Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI * (j + 1)
                        + (fazy[j] * 57.29))));
            }
        }

        /*
         * TESTED
         */
        // double value = 0;
        // double sinus = 0;
        // double help1;
        // double help2;
        // double helpVal;
        // for (int i = 0; i < buf.length; i++) {
        // // value = amplitudy[0]
        // // * 127.0
        // // * (Math.sin(i / (SAMPLE_RATE / hzs) * 2.0 * Math.PI) + fazy[0] *
        // // 57.29);
        // value = 0;
        // help1 = i / (SAMPLE_RATE / hzs);
        // for (int j = 0; j < amplitudy.length; j++) {
        // help2 = help1 * 6.28 * (j + 1);
        // if (amplitudy[j] != 0 && i != 0) {
        // sinus = Math.sin(help2 + fazy[j] * 57.29);
        // }
        // helpVal = 127 * amplitudy[j] * sinus;
        // value = value + helpVal;
        // }
        // buf[i] = (byte) value;
        // }

        AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 2, true, false);
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        sdl.write(buf, 0, buf.length);
        sdl.drain();
        sdl.close();
    }

    public void play() throws LineUnavailableException {
        int size = ampls.size();
        fazy = new double[size];
        amplitudy = new double[size];

        setArrays(fazy, phases);
        setArrays(amplitudy, ampls);
        setFrekv();
        sound(1000);
    }

    private void setArrays(double[] array, ArrayList<JTextField> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = Double.parseDouble(arrayList.get(i).getText());
        }
    }

    private void setFrekv() {
        hzs = frekv.get(0);
    }
}
