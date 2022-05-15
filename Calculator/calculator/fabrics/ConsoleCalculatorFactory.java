package com.task2.calculator.fabrics;

import com.task2.calculator.ICalculator;
import com.task2.calculator.CalculatorFactory;
import com.task2.calculator.domain.ConsoleCalculator;

public class ConsoleCalculatorFactory extends CalculatorFactory {
    @Override
    public ICalculator createCalculator(String filename) {
        return new ConsoleCalculator();
    }
}
