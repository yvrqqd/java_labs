package Calculator;

import Calculator.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        String filename = (args.length != 0) ? args[0] : "";
        Calculator Calc;
        Calc = new Calculator();
        Calc.calculate(filename);
    }
}
