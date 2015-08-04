package listeners;

import interfaceCalc.CalculatorUI;
import logicCalc.LogicCalculator;
import logicCalc.MathOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by алла on 03.08.15.
 */
public class OperationActionListener implements ActionListener {
    public static JTextArea inputOutputText1 = CalculatorUI.inputOutputText1;
    public static JTextArea inputOutputText2 = CalculatorUI.inputOutputText2;
    @Override
    public void actionPerformed(ActionEvent e) {
        String text2 = inputOutputText2.getText();
        if (MathOperations.isFractionalAndIntegerNumber(text2) || "+".equals(text2) || "-".equals(text2) || "/".equals(text2) || "*".equals(text2) || "=".equals(text2) || "%".equals(text2)) {
            int length = text2.length();
            inputOutputText1.append(text2); /// ??? %%%
            inputOutputText2.replaceRange(null, 0, length);
            String getActionCommandString = e.getActionCommand();
            inputOutputText2.append(getActionCommandString);

            // if the operation is called  "equal"
            if ("=".equals(getActionCommandString)) {
                inputOutputText2.replaceRange(null, 0, getActionCommandString.length()); // стираем "="
                String text = inputOutputText1.getText();
                String string = LogicCalculator.calculate(text);

                // input to console
                System.out.println(string);

                inputOutputText2.append(string);
            }

            // TODO:will soon be implemented
            // в случае если вызывается операция "взятие процента"
            if ("%".equals(getActionCommandString)) {
                String str = inputOutputText2.getText();
                inputOutputText2.replaceRange(null, 0, str.length());
                inputOutputText2.append("The % is not implemented");
                    /*
                    String text1 = inputOutputText1.getText();
                    inputOutputText2.replaceRange(null, 0, getActionCommandString.length());
                    String string = logicCalc.LogicCalculator.percent(text1);
                    System.out.println(string);//// output in the screen percent
                    inputOutputText2.append(string);
                    inputOutputText1.replaceRange(null, 0, text1.length());

                   // inputOutputText1.replaceRange(null, 0, text1.length());
                    //String text1New = logicCalc.LogicCalculator.ChangeLastNumber(inputOutputText2.getText(), text1);
                   // inputOutputText1.append( text1New );
                    */
            }
        }
    }

    // TODO:will soon be implemented
   /* private String getPersent(){
        String text = inputOutputText1.getText();
        logicCalc.LogicCalculator logicColculator = new logicCalc.LogicCalculator(text);
        String string = logicColculator.equals.toString();
        System.out.println(string);
        return string;
    }*/
}


