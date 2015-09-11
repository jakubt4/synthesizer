package gui.components;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;

public interface ElementsChangesListener {
    ArrayList<JTextField> ampls = new ArrayList<>();
    ArrayList<JTextField> phases = new ArrayList<>();
    ArrayList<Integer> frekv = new ArrayList<>();

    ArrayList<JSlider> amplsSliders = new ArrayList<>();
    ArrayList<JSlider> phasesSliders = new ArrayList<>();

    ArrayList<JTextField> frekvTF = new ArrayList<>();

    ArrayList<JFrame> frames = new ArrayList<>();
    ArrayList<Integer> NUMBER_OF_ELEMENTS = new ArrayList<>();

}