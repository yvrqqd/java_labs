package Calculator.operations;

import Calculator.calculator.Container;

import java.io.InputStreamReader;

public interface IOperation {
    void operate(Container context, InputStreamReader reader);
}
