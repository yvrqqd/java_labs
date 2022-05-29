package Calculator.operations.opers;

import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;


public class Print implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException {
        if (CustomContainer.stack_depth() < 1) {
            throw new StackDepthException("Passed " + (args.length-1) + " args in PRINT");
        } else {
           System.out.println(CustomContainer.peek());
        }
    }
}
