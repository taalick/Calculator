package listeners;

import interfaceCalc.CalculatorUI;
import logicCalc.MathOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by алла on 03.08.15.
 */
public class DeleteLastCharactActionListener implements ActionListener {
    public static JTextArea inputOutputText2 = CalculatorUI.inputOutputText2;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = inputOutputText2.getText();
        int length = text.length();
        inputOutputText2.replaceRange(null, 0, length);
        inputOutputText2.append(MathOperations.deleteTheLastCharacter(text));
    }
}

