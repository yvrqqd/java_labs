package Calculator.calculator;

import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;
import Calculator.operations.OperationFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class);
    CustomContainer context = new CustomContainer(new Stack<>(), new HashMap<>());

    public void calculate(String filename) {   // 0 = console, 1 = file
        PropertyConfigurator.configure("Calculator/log/log.properties");
        logger.debug("Starting computing");
        OperationFactory Fac = new OperationFactory();
        try {
            String[] command;
            logger.debug("Initialising scanner");
            Scanner scan = (Objects.equals(filename, "")) ? new Scanner(System.in) : new Scanner(filename);
            while (scan.hasNextLine()) {
                logger.debug("Parsing new line");
                command = scan.nextLine().toUpperCase().trim().replaceAll("\\s{2,}", " ").split(" ");
                if (Objects.equals(command[0], "")) continue;
                try {
                    IOperation op = Fac.makeOperation(command[0]);
                    if (op != null) {
                        op.operate(context, command);
                    }
                } catch (InvalidNumberOfArgs | StackDepthException ignored) {
                    logger.info("Exception in operation was caught");
                }
            }
        } catch (Exception e) {
            logger.info("Exception in calculate was caught");
            System.out.println("Exception in Calculator class." + e);
        }
    }
}