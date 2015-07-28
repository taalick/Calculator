package interfaceCalc;

import logicCalc.MathOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public  class ActionMemory implements ActionListener {
        public static JTextArea inputOutputText1 = InterfaceCalculator.inputOutputText1;
        public static JTextArea inputOutputText2 = InterfaceCalculator.inputOutputText2;
        public static JTextArea inputOutputText3 = InterfaceCalculator.inputOutputText3;

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputOutputText2.getText();
            int length = text.length();
            switch (text){
                case "0":
                    inputOutputText2.replaceRange(null, 0, length);
                    if(inputOutputText1.getText().equals("0")){
                        int lenght = inputOutputText1.getText().length();
                        inputOutputText1.replaceRange(null, 0, lenght);
                    }
                    break;
                case "=":
                case "+":
                case "-":
                case "/":
                case "*":
                    if(!inputOutputText1.getText().equals(null)) {
                        inputOutputText1.append(" " + text + " ");
                    } else {
                        inputOutputText1.append(text + " ");
                    }
                    inputOutputText2.replaceRange(null, 0, length);
                    break;
            }

            switch (e.getActionCommand()){
                case "MS":boolean fullMemory =  MathOperations.memory_write(text);
                    if(fullMemory){
                        int length3 = inputOutputText3.getText().length();
                        inputOutputText3.replaceRange(null, 0, length3);
                        inputOutputText3.append("M");
                    }
                    break;
                case "MR": String outputText =  MathOperations.output_memory();
                    int length2 = inputOutputText2.getText().length();
                    inputOutputText2.replaceRange(null, 0, length2);
                    inputOutputText2.append(outputText);
                    break;
                case "MC": MathOperations.cleaning_memory();
                    int length3 = inputOutputText3.getText().length();
                    inputOutputText3.replaceRange(null, 0, length3);
                    break;
                case "M+": boolean fullMemory1 = MathOperations.addition_memory(text);
                    if(fullMemory1){
                        int length4 = inputOutputText3.getText().length();
                        inputOutputText3.replaceRange(null, 0, length4);
                        inputOutputText3.append("M");
                    }
                    break;
                case "M-": boolean fullMemory2 = MathOperations.subtraction_memory(text);
                    if(fullMemory2){
                        int length5 = inputOutputText3.getText().length();
                        inputOutputText3.replaceRange(null, 0, length5);
                        inputOutputText3.append("M");
                    }
                    break;
            }
        }
    }
