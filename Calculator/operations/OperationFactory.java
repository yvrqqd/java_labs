package Calculator.operations;

import Calculator.calculator.Container;

public class OperationFactory {
    public IOperation makeOperation(String operation) {
        switch (operation) {
            case "#":
            case "DEFINE":
            case "/":
            case "-":
            case "*":
            case "+":
            case "POP":
            case "PRINT":
            case "PUSH":
            case "SQRT":
            default: break;
        }
        return null;
    }
}
