import ONP.*;

public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            String input = args[i];
            String inputInONP = infixToONP.converseInfixToPostfix(input);
            String outputInInfix = infixToONP.conversePostfixToInfix(inputInONP);
            double result = calculatorONP.equationSolver(inputInONP);
            System.out.println("Input " + (i + 1) + ": \"" + input + "\"");
            System.out.println("Input in ONP " + (i + 1) + ": " + inputInONP);
            System.out.println("Result " + (i + 1) + ": " + result);
            System.out.println("Result " + (i + 1) + ": " + outputInInfix);
            System.out.println();
        }

    }
}

