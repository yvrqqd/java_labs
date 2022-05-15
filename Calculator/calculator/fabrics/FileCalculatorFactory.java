package com.task2.calculator.fabrics;

import com.task2.calculator.ICalculator;
import com.task2.calculator.CalculatorFactory;
import com.task2.calculator.domain.FileCalculator;

public class FileCalculatorFactory extends CalculatorFactory {
    @Override
    public ICalculator createCalculator(String filename) {
        return new FileCalculator(filename);
    }
}
