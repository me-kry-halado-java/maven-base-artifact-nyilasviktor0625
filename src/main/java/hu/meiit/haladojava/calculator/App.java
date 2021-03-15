package hu.meiit.haladojava.calculator;
import java.security.PrivateKey;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{


    public static void main( String[] args ) {
       
        try {
            Analyz analyz = new Analyz();
            Input input = new Input();
            String result = analyz.getErrorResponse();
            String exprFromStdin = input.getExpressionFromStdin();
            String[] parts = input.parse(exprFromStdin);
            input.assertExpression(parts);
            Expression expression = analyz.getAsExpression(parts);
            result = analyz.executeExpression(expression);
        }catch(Exception ex ){}
        System.out.print(result);


    }
}
