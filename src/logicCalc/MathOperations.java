package logicCalc;

import java.util.ArrayList;
import java.io.*;

public class MathOperations  {

    public static Double addition(Double a, Double b) {
        Double c = a + b;
        return c;
    }

    public static Double subtraction(Double a, Double b) {
        Double c = a - b;
        return c;
    }

    public static Double division(Double a, Double b) {
        Double c = a / b;
        return c;
    }

    public static Double multiplication(Double a, Double b) {
        Double c = a * b;
        return c;
    }

    public static Double taking_percent(Double a, Double b) {
        Double c = a/100*b;
        return c;
    }

    public static String square_root(String a) {
        Double aDouble = new Double(a);
        Double b = (double)0;
        if(isFractionalAndIntegerNumber(a)){
            b = Math.sqrt(aDouble);
        }
        return b.toString();
    }

    public static String fraction(String a) {
        Double aDouble = new Double(a);
        Double b = (double)0;
        if(isFractionalAndIntegerNumber(a)){
            b = 1/aDouble;
        }
        return b.toString();
    }

    public static String delete_the_last_character(String s) {
        int sLenght = s.length();
        String s1 = s.substring(0, sLenght-1);
        return s1;
    }

    // Write a string to a file, if the file does not exist is created if a file exists and removes and the newly creates
    // Returns the true if the file includes some characters other than "0", "0.0" or null, otherwise false
    public static boolean memory_write(String a) {
        boolean fullMemory = true;
        try{
            File file = new File("D:\\Calculator\\calculator_memory.txt");
            if(!file.canExecute()){
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Calculator\\calculator_memory.txt");

            char[] arrayChar = a.toCharArray();
            byte[] arrayByte = new byte[arrayChar.length];
            for(int i=0; i<arrayByte.length; i++){
                arrayByte[i] = (byte)arrayChar[i];
            }
            fileOutputStream.write(arrayByte);

            // Check content file if "0", "0.0" or null memory is empty
            FileInputStream fileInputStream = new FileInputStream("D:\\Calculator\\calculator_memory.txt");
            ArrayList<Character> arrayCharList = new ArrayList<>();
            while(fileInputStream.available() > 0){
                int num = fileInputStream.read();
                arrayCharList.add((char)num);
            }
            String str = new String();
            for(int i=0; i<arrayCharList.size(); i++){
                str += arrayCharList.get(i).toString();
            }
            if("0".equals(str) || "0.0".equals(str) || str.equals(null)){
                fullMemory = false;
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e){

        } catch (IOException e){

        }
        return fullMemory;
    }

    public static boolean addition_memory(String a) {
        boolean fullMemory = true;
        try{
        File file = new File("D:\\Calculator\\calculator_memory.txt");
        if(!file.canExecute()){
            file.createNewFile();
        }
            FileInputStream inputStream = new FileInputStream(file);
            ArrayList<Character> arrayChar = new ArrayList<>();
            while(inputStream.available() > 0){
                int num = inputStream.read();
                arrayChar.add((char)num);
            }
            String str = new String();
            for(int i=0; i<arrayChar.size(); i++){
                str += arrayChar.get(i).toString();
            }
            Double b = Double.parseDouble(str);

            Double aDouble = Double.parseDouble(a);
            Double sum = b + aDouble;

            // input to console
            System.out.println("Input to memory " + sum);

            fullMemory = memory_write(sum.toString());
            inputStream.close();
        } catch (IOException e){
        } catch (NumberFormatException e){}
        return fullMemory;
    }

    public static boolean subtraction_memory(String a) {
        boolean fullMemory = true;
        try{
            File file = new File("D:\\Calculator\\calculator_memory.txt");
            if(!file.canExecute()){
                file.createNewFile();
            }
            FileInputStream inputStream = new FileInputStream(file);
            ArrayList<Character> arrayChar = new ArrayList<>();
            while(inputStream.available() > 0){
                int num = inputStream.read();
                arrayChar.add((char)num);
            }
            String str = new String();
            for(int i=0; i<arrayChar.size(); i++){
                str += arrayChar.get(i).toString();
            }
            Double b = Double.parseDouble(str);

            Double aDouble = Double.parseDouble(a);
            Double sum = b - aDouble;

            // input to console
            System.out.println("Input to memory " + sum);

            fullMemory = memory_write(sum.toString());
            inputStream.close();
        } catch (IOException e){
        } catch (NumberFormatException e){}
        return fullMemory;
    }

    public static String output_memory() {
        try{
            File file = new File("D:\\Calculator\\calculator_memory.txt");
            if(!file.canExecute()){
                return "not found file";
            } else {
            FileInputStream inputStream = new FileInputStream("D:\\Calculator\\calculator_memory.txt");
            ArrayList<Character> arrayChar = new ArrayList<>();
            while(inputStream.available() > 0){
                int num = inputStream.read();
                arrayChar.add((char)num);
            }
            String str = new String();
            for(int i=0; i<arrayChar.size(); i++){
                str += arrayChar.get(i).toString();
            }
            inputStream.close();
            return str;
            }

        } catch (IOException e){
            return "IOException";
        }
    }

    public static boolean cleaning_memory() {
        try{
            File file = new File("D:\\Calculator\\calculator_memory.txt");
            if(!file.canExecute()){
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            memory_write("0.0");
        } catch (IOException e){}
        return true;
    }

    public static String about_programm() {
        String s = new String();

        try{
            FileInputStream inputStream = new FileInputStream("D:\\Calculator\\about_programm.txt");
            byte[] arrayByte = new byte[inputStream.available()];
            while(inputStream.available() > 0){
                inputStream.read(arrayByte);
            }
            char[] arrayChar = new char[arrayByte.length];
            for(int i=0; i < arrayChar.length; i++){
                arrayChar[i] = (char)arrayByte[i];
            }
            for(int i=0; i<arrayChar.length; i++){
                s += arrayChar[i];
            }
            inputStream.close();
        } catch (IOException e){}

        return s;
    }

    // TODO: will soon be implemented: copy(), insert(),usual(), engineering()

    public static void copy(){};
    public static void insert(){};
    public static void usual(){};
    public static void engineering(){};

    // return true if is fractional or integer number
    // false in other case
    public static boolean isFractionalAndIntegerNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];

            if (
                        // there is a '-' inside a string
                    (i != 0 && c == '-')
                        // is not a digit and is not '-'  and is not '.'
                    || (!Character.isDigit(c) && c != '-' && c != '.' )
                        // first character '.'
                    || (i == 0 && c == '.')
                        // last character '.'
                    || (i == chars.length-1 && c == '.'))
            {
                return false;
            }
        }
        return true;
    }

    // return true if is integer number
    // false in other case
    public static boolean isIntegerNumber(String s)
    {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (
                        // there is a '-' inside a string
                    (i != 0 && c == '-')
                        // is not a digit and is not '-'
                    || (!Character.isDigit(c) && c != '-' )  ){
                return false;
        }
        }
        return true;
    }

    // return true if string is positive number
    // false in other case
    public static boolean isPositiveNum(String s){
        if (isFractionalAndIntegerNumber(s)){
            if(!"-".equals(s.substring(0, 1))){
            return true;
            }
        }
        return false;
    }

    // cuts the null character string "s"
    // returns a new line "sNew", the resulting cutoff zero symbol string "s"
    public static String toPositiveNum(String s){
        String sNew = new String();
        char[] arrayString = s.toCharArray();
        if(isFractionalAndIntegerNumber(s) && !isPositiveNum(s)){
            for(int i=0; i<arrayString.length; i++){
               if(i!=0){
                  sNew += arrayString[i];
               }
            }
        }
        return sNew;
    }
}
