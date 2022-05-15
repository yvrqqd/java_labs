package com.task2.operations;

import com.task2.calculator.Container;

public abstract class OperationFactory {
    public abstract IOperation makeOperation(Container context);
}
