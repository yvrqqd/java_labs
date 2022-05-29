package Calculator.operations;

import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;

public interface IOperation {
    void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException;
}
