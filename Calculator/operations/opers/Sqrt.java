package Calculator.operations.opers;

import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;


public class Sqrt implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException {
        if (args.length != 1) {
            throw new InvalidNumberOfArgs("Passed " + (args.length-1) + " args in SQRT");
        } else if (CustomContainer.stack_depth() < 1) {
            throw new StackDepthException("Less the 1 var in stack during sqrt" + CustomContainer.stack_depth());
        } else {
            double var1 = CustomContainer.pop();
            CustomContainer.push(Math.sqrt(var1));
        }
    }
}

