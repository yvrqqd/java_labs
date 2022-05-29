package Calculator.exceptions;


public class InvalidNumberOfArgs extends Exception{
    public InvalidNumberOfArgs(String errorMessage) {
        System.out.println(errorMessage);
    }
}
