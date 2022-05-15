package com.task2.operations.fabric;

import com.task2.calculator.Container;
import com.task2.operations.IOperation;
import com.task2.operations.OperationFactory;
import com.task2.operations.domain.Comment;

public class PlusFabric extends OperationFactory {

    @Override
    public IOperation makeOperation(Container context) {
        return new Comment();
    }
}
