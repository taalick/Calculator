package interfaceCalc;

import javax.swing.*;

public class PlansImplementation extends JFrame {
    public JTextArea text;
    public PlansImplementation(){
        super("Планируется реализовать");
        String str = "Вскоре планируется реализовать";
        text = new JTextArea(str);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        setContentPane(text);
        setSize(250, 200);
        setVisible(true);
    }
}
