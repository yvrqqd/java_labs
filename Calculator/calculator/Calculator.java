package Calculator.calculator;

import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;
import Calculator.operations.OperationFactory;

import java.util.*;


public class Calculator {
    CustomContainer context = new CustomContainer(new Stack<>(), new HashMap<>());

    public void calculate(String filename) {   // 0 = console, 1 = file
        OperationFactory Fac = new OperationFactory();
        try {
            String[] command;
            Scanner scan = (Objects.equals(filename, "")) ? new Scanner(System.in) : new Scanner(filename);
            while (scan.hasNextLine()) {
                command = scan.nextLine().toUpperCase().trim().replaceAll("\\s{2,}", " ").split(" ");
                if (Objects.equals(command[0], "")) continue;
                try {
                    IOperation op = Fac.makeOperation(command[0]);
                    if (op != null) {
                        op.operate(context, command);
                    }
                } catch (InvalidNumberOfArgs | StackDepthException ignored) {
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Calculator class." + e);
        }
    }
}