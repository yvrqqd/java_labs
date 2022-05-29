package Calculator.calculator;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class Calculator {
    Container context = new Container(new Stack<>(), new HashMap<>(), new Vector<>());

    HashMap<String, Class<?>> loadAvailableOperationFabrics() {

        HashMap<String, Class<?>> map = new HashMap<>();
        String[] res;
        var i = 0;
        Scanner scan = new Scanner("props");
        try {
            while (scan.hasNextLine()) {
                res = scan.next().split("=");
                map.put(res[0], Class.forName(res[1]));
                System.out.println(res[1]);
            }
        } catch (Exception ignored) {
            System.out.println("ERROR during initialising factories");
        }
        return map;
    }

    String _filename;
    HashMap<String, Class<?>> _operationFactories = loadAvailableOperationFabrics();

    public void calculate(int type, String filename) {   // 0 = console, 1 = file
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

        if (type == 1) {

        } else{

        }

    }
}