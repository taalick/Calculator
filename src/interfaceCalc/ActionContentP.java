package interfaceCalc;

import logicCalc.LogicCalculator;
import logicCalc.MathOperations;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionContentP {

    public static JTextArea inputOutputText1 = InterfaceCalculator.inputOutputText1;
    public static JTextArea inputOutputText2 = InterfaceCalculator.inputOutputText2;

    public static class ActionNumbers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text1 = inputOutputText1.getText();
            if("0".equals(text1)){
                int lenghtText1 = text1.length();
                inputOutputText1.replaceRange(null,0, lenghtText1 );
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
            switch (text2){
                case "0":
                    inputOutputText2.replaceRange(null, 0, length);
                    break;
                case "=":
                case "+":
                case "-":
                case "/":
                case "*":
                case "%":
                    if(!inputOutputText1.getText().equals(null)) {
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

    public static class ActionComma implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            if(MathOperations.isIntegerNumber(text)){
                inputOutputText2.append(e.getActionCommand());
            }
        }
    }

    public static class ActionOctothorpe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            if(MathOperations.isPositiveNum(text)){
                inputOutputText2.replaceRange(null, 0, text.length());
                inputOutputText2.append(e.getActionCommand() + text);
            } else if(!MathOperations.isPositiveNum(text)){
                inputOutputText2.replaceRange(null, 0, text.length());
                inputOutputText2.append(MathOperations.toPositiveNum(text));
            }
        }
    }
    public static class ActionFraction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            String num = MathOperations.fraction(text);
            inputOutputText2.replaceRange(null, 0, text.length());
            inputOutputText2.append(num);
        }
    }

    public static class ActionSquareRoot implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            String num = MathOperations.squareRoot(text);
            inputOutputText2.replaceRange(null, 0, text.length());
            inputOutputText2.append(num);
        }
    }

    public static class ActionOperation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text2 = inputOutputText2.getText();
            if(MathOperations.isFractionalAndIntegerNumber(text2) || "+".equals(text2) || "-".equals(text2) || "/".equals(text2) || "*".equals(text2) ||  "=".equals(text2) || "%".equals(text2)){
                int length = text2.length();
                inputOutputText1.append(text2); /// ??? %%%
                inputOutputText2.replaceRange(null, 0, length );
                String getActionCommandString = e.getActionCommand();
                inputOutputText2.append(getActionCommandString);

                // if the operation is called  "equal"
                if("=".equals(getActionCommandString)){
                    inputOutputText2.replaceRange(null, 0, getActionCommandString.length() ); // стираем "="
                    String text = inputOutputText1.getText();
                    String string = LogicCalculator.calculate(text);

                    // input to console
                    System.out.println(string);

                    inputOutputText2.append(string);
                }

                // TODO:will soon be implemented
                // в случае если вызывается операция "взятие процента"
                if("%".equals(getActionCommandString)){
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
    }



    public static class ActionDeleteLastCharact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            int length = text.length();
            inputOutputText2.replaceRange(null, 0, length);
            inputOutputText2.append(MathOperations.deleteTheLastCharacter(text));
        }
    }

    public static class ActionC implements ActionListener {
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


    public static class ActionUndoLastAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text2 = inputOutputText2.getText();
            int length2 = text2.length();
            inputOutputText2.replaceRange(null, 0, length2);
            inputOutputText2.append("0");
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
