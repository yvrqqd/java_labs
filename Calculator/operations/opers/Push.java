package Calculator.operations.opers;

import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.operations.IOperation;


public class Push implements IOperation {
    @Override
    public void operate(CustomContainer context, String[] args) throws InvalidNumberOfArgs {
        if (args.length != 2) {
            throw new InvalidNumberOfArgs("Passed " + (args.length-1) + " args in PUSH");
        } else {
            CustomContainer.push(CustomContainer.defined(args[1]));
        }
    }
}
