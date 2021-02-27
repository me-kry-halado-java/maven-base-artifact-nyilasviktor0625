package hu.meiit.haladojava.calculator;

import java.util.Scanner;

public class Input {


    public static String [] parse(String expression){
        String[] returnValue = new String[0];
        if(expression.length()>3) {
             returnValue = expression.split(" ");

        }
        else if(expression.length()==3)
        {returnValue=expression.split("");
        }
        return returnValue;
    }


    public static String getExpressionFromStdin(){
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        return  expression;
    }


    public static void assertExpression(String[] parts ) throws Exception{

        if (parts.length != 3) {
            throw new Exception("wrong input");
        }
    }

}
