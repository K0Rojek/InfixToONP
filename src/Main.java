public class Main {
    public static void main(String[] args) {
        String input =  "(15-3)^(3+2)*6/3=";
        String output = infToONP.converseInfixToPostfix(input);
        System.out.println(output);
    }
}

