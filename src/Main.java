public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            String input = args[i];
            String inputInONP = infToONP.converseInfixToPostfix(input);
            double result = calculatorONP.equationSolver(inputInONP);
            System.out.println("Input " + i + ": \"" + input + "\"");
            System.out.println("Input in ONP " + i + ": " + inputInONP);
            System.out.println("Result " + i + ": " + result);
            System.out.println();
        }

    }
}

