public class infToONP {
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

    public static String converseInfixToPostfix(String equation) {
        String[] stringStack = new String[10];
        int stackTop = -1;
        String postfixOutput = "";
        int equationLength = equation.length();
        for (int i = 0; i < equationLength; i++) {
            char c = equation.charAt(i);
            if (Character.isDigit(c)) {
                String number = "" + c;
                while (i + 1 < equationLength && Character.isDigit(equation.charAt(i + 1))) {
                    number = number + equation.charAt(i + 1);
                    i++;
                }
                postfixOutput = postfixOutput + number + " ";
            } else if (c == '(') {
                stackTop++;
                stringStack[stackTop] = String.valueOf(c);
            } else if (c == ')') {
                while (stackTop >= 0 && !stringStack[stackTop].equals("(")) {
                    postfixOutput = postfixOutput + stringStack[stackTop] + " ";
                    stackTop--;
                }
                stackTop--; // Pop the "(" from the stack
            } else if (c == '=') {
                while (stackTop >= 0) {
                    postfixOutput = postfixOutput + stringStack[stackTop] + " ";
                    stackTop--;
                }
                postfixOutput = postfixOutput + "=";
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') {
//                postfixOutput = postfixOutput + " ";
                while (stackTop >= 0 && getPriorityONP(c) <= getPriorityONP(stringStack[stackTop].charAt(0))) {
                    postfixOutput = postfixOutput + stringStack[stackTop] + " ";
                    stackTop--;
                }
                stackTop++;
                stringStack[stackTop] = String.valueOf(c);
            }
        }

        return postfixOutput;
    }
}
