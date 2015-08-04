package listeners;

import interfaceCalc.CalculatorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by алла on 03.08.15.
 */
public class UndoLastActionListener implements ActionListener {
    public static JTextArea inputOutputText2 = CalculatorUI.inputOutputText2;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text2 = inputOutputText2.getText();
        int length2 = text2.length();
        inputOutputText2.replaceRange(null, 0, length2);
        inputOutputText2.append("0");
    }
}

