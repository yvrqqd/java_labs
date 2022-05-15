package com.task2.calculator.domain;

import com.task2.calculator.ICalculator;
import com.task2.operations.OperationFactory;

import java.util.HashMap;
import java.util.Scanner;


public class ConsoleCalculator implements ICalculator {
    HashMap<String, Class<?>> _operationFactories = loadAvailableOperationFabrics();
    @Override
    public void calculate() {
        try {
            String command;
            Scanner scan = new Scanner(System.in);
            while (scan.hasNextLine()) {
                command = scan.next();
                context.args.clear();
                if (_operationFactories.containsKey(command)) {
                    _operationFactories.get(command).getConstructor().newInstance();
                } else {
                    System.out.println("NO SUCH COMMAND");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in Factory." + e);
        }
    }
}
