package ONP;

public class infixToONP {
    /**
     * Returns the priority of an operator in an expression written in Reverse Polish Notation (ONP)
     * @param operator  the operator whose priority needs to be determined
     * @return  an integer value representing the priority of the given operator in the RPN expression
     */
    public static int getPriorityONP(char operator) {
        switch (operator) {
            case '+', '-':
                return 1;
            case '*', '%', '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    /**
     * Converts an infix notation equation to a postfix notation equation.
     * @param equation  the equation to be converted in infix notation
     * @return  the converted equation in postfix notation
     */
    public static String converseInfixToPostfix(String equation) {
        String[] stringStack = new String[10];
        int stringStackTop = -1;
        StringBuilder postfixOutput = new StringBuilder();
        int equationLength = equation.length();
        for (int i = 0; i < equationLength; i++) {
            char character = equation.charAt(i);
            if (Character.isDigit(character)) {
                StringBuilder number = new StringBuilder();
                number.append(character);
                while (i + 1 < equationLength && (Character.isDigit(equation.charAt(i + 1)) || equation.charAt(i + 1) == '.')) {
                    number.append(equation.charAt(i + 1));
                    i++;
                }
                postfixOutput.append(number).append(" ");
            } else if (character == '(') {
                stringStackTop++;
                stringStack[stringStackTop] = String.valueOf(character);
            } else if (character == ')') {
                while (stringStackTop >= 0 && !stringStack[stringStackTop].equals("(")) {
                    postfixOutput.append(stringStack[stringStackTop]).append(" ");
                    stringStackTop--;
                }
                stringStackTop--; // Pop the "(" from the stack
            } else if (character == '=') {
                while (stringStackTop >= 0) {
                    postfixOutput.append(stringStack[stringStackTop]).append(" ");
                    stringStackTop--;
                }
                postfixOutput.append("=");
            } else if (character == '+' || character == '-' || character == '*' || character == '/' || character == '%' || character == '^') {
                while (stringStackTop >= 0 && getPriorityONP(character) <= getPriorityONP(stringStack[stringStackTop].charAt(0))) {
                    postfixOutput.append(stringStack[stringStackTop]).append(" ");
                    stringStackTop--;
                }
                stringStackTop++;
                stringStack[stringStackTop] = String.valueOf(character);
            }
        }
        return postfixOutput.toString();
    }
    public static String conversePostfixToInfix(String postfixEquation) {
        String[] stringStack = new String[10];
        int stringStackTop = -1;
        int equationLength = postfixEquation.length();
        for (int i = 0; i < equationLength; i++) {
            char character = postfixEquation.charAt(i);
            if (Character.isDigit(character)) {
                StringBuilder number = new StringBuilder();
                number.append(character);
                while (i + 1 < equationLength && (Character.isDigit(postfixEquation.charAt(i + 1)) || postfixEquation.charAt(i + 1) == '.')) {
                    number.append(postfixEquation.charAt(i + 1));
                    i++;
                }
                stringStackTop++;
                stringStack[stringStackTop] = number.toString();
            } else if (character == '+' || character == '-' || character == '*' || character == '/' || character == '%' || character == '^') {
                String operand2 = stringStack[stringStackTop];
                stringStackTop--;
                String operand1 = stringStack[stringStackTop];
                stringStackTop--;
                String infixExpression = "(" + operand1 + " " + character + " " + operand2 + ")";
                stringStackTop++;
                stringStack[stringStackTop] = infixExpression;
            }
        }
        return stringStack[stringStackTop];
    }

}

