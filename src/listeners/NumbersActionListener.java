package listeners;

import interfaceCalc.CalculatorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by алла on 03.08.15.
 */
public class NumbersActionListener implements ActionListener {
    public static JTextArea inputOutputText1 = CalculatorUI.inputOutputText1;
    public static JTextArea inputOutputText2 = CalculatorUI.inputOutputText2;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text1 = inputOutputText1.getText();
        if ("0".equals(text1)) {
            int lenghtText1 = text1.length();
            inputOutputText1.replaceRange(null, 0, lenghtText1);
        }
        String text2 = inputOutputText2.getText();
        int length = text2.length();

        // TODO:for implementetion button_percent
           /* if(logicCalc.MathOperations.isFractionalNumber(text2) && !text2.equals("0")){
                text2 = "isFractionalNumber";
            }*/
            /*
            if(LogicCalculator.splitText(text1) >= 3){
                inputOutputText1.replaceRange(null, 0, text1.length());
                inputOutputText1.append(text2);
            }*/
        switch (text2) {
            case "0":
                inputOutputText2.replaceRange(null, 0, length);
                break;
            case "=":
            case "+":
            case "-":
            case "/":
            case "*":
            case "%":
                if (!inputOutputText1.getText().equals(null)) {
                    inputOutputText1.append(" " + text2 + " ");
                } else {
                    inputOutputText1.append(text2 + " ");
                }
                inputOutputText2.replaceRange(null, 0, length);
                break;
            case "isFractionalNumber":
                break;
        }
        inputOutputText2.append(e.getActionCommand());  // ставим не в условие вывод значения кнопки т к цыфра пишется в любом случае кроме вышеперечисленных
    }
}

