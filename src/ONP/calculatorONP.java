package ONP;

import java.lang.Math;

public class calculatorONP {

    public static double twoArgumentOperationsCalculator(double argument1, double argument2, char operator) {
        switch (operator) {
            case '+':
                return argument1 + argument2;
            case '-':
                return argument1 - argument2;
            case '*':
                return argument1 * argument2;
            case '/':
                return argument1 / argument2;
            case '%':
                return argument1 % argument2;
            case '^':
                return Math.pow(argument1, argument2);
            default:
                return 0.0;
        }
    }
    public static double equationSolver(String equationInONP) {
        String[] stringStack = new String[10];
        int stringStackTop = -1;
        int equationLength = equationInONP.length();
        for (int i = 0; i < equationLength; i++){
            char character = equationInONP.charAt(i);
            if (Character.isDigit(character)) {
                stringStackTop++;
                StringBuilder number = new StringBuilder();
                number.append(character);
                while (i + 1 < equationLength && Character.isDigit(equationInONP.charAt(i + 1))) {
                    number.append(equationInONP.charAt(i + 1));
                    i++;
                }
                stringStack[stringStackTop] = number.toString();
            } else if (character == '+' || character == '-' || character == '*' || character == '/' || character == '%' || character == '^') {
                //getting 2 arguments for next operation
                double youngerArgument = Double.parseDouble(stringStack[stringStackTop]);
                stringStackTop--;
                double olderArgument = Double.parseDouble(stringStack[stringStackTop]);
                //stringStackTop is not decremented, because in that spot, we will put operationResult, and we also will not increment stringStackTop after doing that
                double operationResult = twoArgumentOperationsCalculator(olderArgument, youngerArgument, character);
                stringStack[stringStackTop] = String.valueOf(operationResult);
            }
        }
        return Double.parseDouble(stringStack[0]);
    }
}
