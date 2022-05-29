package Calculator;

import Calculator.calculator.Calculator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filename;
        Calculator Calc = new Calculator();

        if (args.length != 0) {
            filename = args[0];
            File f = new File(filename);
            if (f.exists() && !f.isDirectory()) {
                Calc.calculate(1, filename);
            }
        } else {
            Calc.calculate(0, "");
        }
    }
}
