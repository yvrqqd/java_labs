package com.task2.calculator;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public interface ICalculator {
    Container context = new Container(new Stack<>(), new HashMap<>(), new Vector<>());

    default HashMap<String, Class<?>> loadAvailableOperationFabrics() {

        HashMap<String, Class<?>> map = new HashMap<>();
        String[] res;
        var i = 0;
        Scanner scan = new Scanner("props");
        try {
            while (scan.hasNextLine()) {
                res = scan.next().split("=");
                map.put(res[0], Class.forName(res[1]));
            }
        } catch (Exception ignored) {
            System.out.println("ERROR during initialising factories");
        }
        return map;
    }

    void calculate();
}
