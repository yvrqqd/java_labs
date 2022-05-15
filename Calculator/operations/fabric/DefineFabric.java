package com.task2.operations.fabric;

import com.task2.operations.IOperation;

import com.task2.calculator.Container;
import com.task2.operations.OperationFactory;

public class DefineFabric extends OperationFactory {
//    @Override
//    public void operate(Container context) {
//
//        double a, b;
//        if (context.stack.empty()) {
//            System.out.println("Stack is empty when attempting to make a \"+\" operation");
//        } else {
//            a = context.stack.pop();
//            if (context.stack.empty()) {
//                System.out.println("Stack has only one value (" + a + ") when attempting to make a \"-\" operation");
//                context.stack.push(a);
//                return;
//            }
//            b = context.stack.pop();
//            context.stack.push(a + b);
//        }
//    }

    @Override
    public IOperation makeOperation(Container context) {
        return null;
    }
}
