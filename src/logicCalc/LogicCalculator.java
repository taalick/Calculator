package logicCalc;

public class LogicCalculator extends MathOperations {

    private static Double a;
    private static Double b;
    private static String c;

     public static int splitText(String text){
        String[] arrayText = text.split(" ");
        int length = arrayText.length;
        if(length==3){
            if(arrayText[0] != "+" && arrayText[0] != "-" && arrayText[0] != "*" && arrayText[0] != "/"  ){
                a = Double.parseDouble(arrayText[0]);
            }

            if(arrayText[1].equals("+") || arrayText[1].equals("-") || arrayText[1].equals("*") || arrayText[1].equals("/")  ){
                c = arrayText[1];
            }

            if(arrayText[2] != "+" && arrayText[2] != "-" && arrayText[2] != "*" && arrayText[2] != "/"  ){
                b = Double.parseDouble(arrayText[2]);
            }

            // input to console
            System.out.println(a + c + b);

        }
         return length;
    }


    public static String equals(String text) {
        LogicCalculator.splitText(text);
        String equal = new String();
        Double equalDouble = null;

            switch (c){
                case "+": equalDouble = MathOperations.addition(a, b);
                    break;
                case "-": equalDouble = MathOperations.subtraction(a, b);
                    break;
                case "*": equalDouble = MathOperations.multiplication(a, b);
                    break;
                case "/": equalDouble = MathOperations.division(a, b);
                    break;
            }
        equal = equalDouble.toString();
       return equal;
    }

    // TODO: will soon be implemented percent(String text)

    public static String percent(String text) {
        LogicCalculator.splitText(text);
        String equal = new String();
        Double equalDouble = null;
        equalDouble = MathOperations.taking_percent(a, b);
        equal = equalDouble.toString();
        return equal;
    }

    // TODO: will soon be implemented ChangeLastNumber(String text)
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
