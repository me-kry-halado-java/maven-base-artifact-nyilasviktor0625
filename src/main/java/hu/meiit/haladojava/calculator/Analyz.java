package hu.meiit.haladojava.calculator;


import static hu.meiit.haladojava.calculator.Analyz.Mathop.*;

public class Analyz {

    public enum Mathop
    {
        PLUS("+"),
        MINUS("-"),
        DIV("/"),
        MULTIP("*");
        private final String operator ;
        Mathop(String operator) {
            this.operator=operator;
        }
        public String getOperator()
        {
            return this.operator;
        }
        public static Mathop getMathopName(String st) {
            for (Mathop operator : Mathop.values()) {
                if (st.equals(operator.getOperator())) {
                    return operator;
                }
            }
            return null;
        }

    };



    private static Mathop currentop;

    private static final String errorResponse = "-";
    private static Mathop operator;
    public static String getErrorResponse() {
        return errorResponse;
    }

    public static Expression getAsExpression(String[] parts) {
        return new Expression(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2]));
    }


    public static String executeExpression(Expression expression){
        Executor executor = new Executor();

        String result = errorResponse;

        switch (Mathop.getMathopName(expression.getOperator()))
        {
            case PLUS:
            {
                result = String.valueOf(expression.getOperand1() + expression.getOperand2());
                break;
            }
            case DIV:
            {
                if(expression.getOperand1()==0 || expression.getOperand2()==0)
                {
                   return result="-";

                }
                else
                {
                    result = String.valueOf(executor.div(expression.getOperand1(), expression.getOperand2()));
                    break;
                }


            }
            case MINUS:
            {
                result = String.valueOf(expression.getOperand1() - expression.getOperand2());
                break;
            }
            case MULTIP:
            {
                result = String.valueOf(executor.multip(expression.getOperand1(), expression.getOperand2()));
                break;
            }
        }


        return result;
    }



}
