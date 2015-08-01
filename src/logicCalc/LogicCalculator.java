package logicCalc;

public class LogicCalculator extends MathOperations {

    private static Double leftOperand;
    private static Double rightOperand;
    private static String operation;

     public static int splitText(String text){
        String[] arrayText = text.split(" ");
        int length = arrayText.length;
        if(length==3){
            if(arrayText[0] != "+" && arrayText[0] != "-" && arrayText[0] != "*" && arrayText[0] != "/"  ){
                leftOperand = Double.parseDouble(arrayText[0]);
            }

            if(arrayText[1].equals("+") || arrayText[1].equals("-") || arrayText[1].equals("*") || arrayText[1].equals("/")  ){
                operation = arrayText[1];
            }

            if(arrayText[2] != "+" && arrayText[2] != "-" && arrayText[2] != "*" && arrayText[2] != "/"  ){
                rightOperand = Double.parseDouble(arrayText[2]);
            }

            // input to console
            System.out.println(leftOperand + operation + rightOperand);
        }
         return length;
    }


    public static String calculate(String text) {
        LogicCalculator.splitText(text);
        switch (operation){
            case "+": return MathOperations.addition(leftOperand, rightOperand).toString();
            case "-": return MathOperations.subtraction(leftOperand, rightOperand).toString();
            case "*": return MathOperations.multiplication(leftOperand, rightOperand).toString();
            case "/": return MathOperations.division(leftOperand, rightOperand).toString();
            default: return "operation is not right" ;
            }
    }

    // TODO:will soon be implemented percent(String text)

    public static String percent(String text) {
        LogicCalculator.splitText(text);
        String equal = new String();
        Double equalDouble = null;
        equalDouble = MathOperations.takingPercent(leftOperand, rightOperand);
        equal = equalDouble.toString();
        return equal;
    }

    // TODO:will soon be implemented ChangeLastNumber(String text)
    // to implement the button %

    public static String ChangeLastNumber(String lastString, String str){
        String strNew = new String();
        String[] arrayStr = str.split(" ");
        int lenght = arrayStr.length;
        arrayStr[lenght-1] = lastString;
        for(int i=0; i<arrayStr.length; i++){
           strNew += arrayStr[i] + " ";
        }
        return strNew;
    }
}
