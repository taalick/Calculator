package listeners;

import interfaceCalc.CalculatorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by алла on 03.08.15.
 */
public class CActionListener implements ActionListener {
    public static JTextArea inputOutputText1 = CalculatorUI.inputOutputText1;
    public static JTextArea inputOutputText2 = CalculatorUI.inputOutputText2;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text1 = inputOutputText1.getText();
        int length1 = text1.length();
        inputOutputText1.replaceRange(null, 0, length1);
        inputOutputText1.append("0");

        String text2 = inputOutputText2.getText();
        int length2 = text2.length();
        inputOutputText2.replaceRange(null, 0, length2);
        inputOutputText2.append("0");
    }
}

