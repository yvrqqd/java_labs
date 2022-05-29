package Calculator.operations.opers;

import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;

import java.io.InputStreamReader;

public class Plus implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs, StackDepthException {
        if (args.length != 1) {
            throw new InvalidNumberOfArgs("Passed " + (args.length-1) + " args in PLUS");
        } else if (CustomContainer.stack_depth() < 2) {
            throw new StackDepthException("Less the 2 vars in stack during plus" + CustomContainer.stack_depth());
        } else {
            double var1 = CustomContainer.pop();
            double var2 = CustomContainer.pop();
            CustomContainer.push(var2 + var1);
        }
    }
}
