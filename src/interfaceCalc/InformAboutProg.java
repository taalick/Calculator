package interfaceCalc;

import logicCalc.MathOperations;

import javax.swing.*;

public class InformAboutProg extends JFrame{
    public JTextArea inform;
    public InformAboutProg(){
        super("О программе");
        String data = MathOperations.aboutProgramm();
        inform = new JTextArea(data, 1, 55);
        inform.setLineWrap(true);
        inform.setWrapStyleWord(true);
        setContentPane(inform);
        setSize(300,200);
        setVisible(true);
    }
}