package com.task2;

import com.task2.calculator.ICalculator;
import com.task2.calculator.CalculatorFactory;
import com.task2.calculator.fabrics.FileCalculatorFactory;
import com.task2.calculator.fabrics.ConsoleCalculatorFactory;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filename;

        if (args.length != 0) {
            filename = args[0];
            File f = new File(filename);
            if (f.exists() && !f.isDirectory()) {
                CalculatorFactory calcF = new FileCalculatorFactory();
                ICalculator fileCalculator = calcF.createCalculator(filename);
                fileCalculator.calculate();
            }
        } else {
            CalculatorFactory calcF = new ConsoleCalculatorFactory();
            ICalculator consoleCalculator = calcF.createCalculator(null);
            consoleCalculator.calculate();
        }
    }
}
