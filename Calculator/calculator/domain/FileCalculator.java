package com.task2.calculator.domain;

import com.task2.calculator.ICalculator;
import com.task2.operations.OperationFactory;

import java.util.HashMap;
import java.util.Scanner;

public class FileCalculator implements ICalculator {
    String _filename;
    HashMap<String, Class<?>> _operationFactories = loadAvailableOperationFabrics();
    public FileCalculator(String filename) {
        super();
        this._filename = filename;
    }
    @Override
    public void calculate() {
        try {
            String command;
            Scanner scan = new Scanner(this._filename);
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
