package com.task2.operations;

import com.task2.calculator.Container;

import java.io.InputStreamReader;

public interface IOperation {
    void operate(Container context, InputStreamReader reader);
}
