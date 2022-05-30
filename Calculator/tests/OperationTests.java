package Calculator.tests;

import Calculator.calculator.Calculator;
import Calculator.calculator.CustomContainer;
import Calculator.exceptions.InvalidNumberOfArgs;
import Calculator.exceptions.StackDepthException;
import Calculator.operations.IOperation;
import Calculator.operations.OperationFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Stack;

public class OperationTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    CustomContainer context = new CustomContainer(new Stack<>(), new HashMap<>());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @BeforeMethod
    public void main() {
        Calculator Calc;
        Calc = new Calculator();
        Calc.calculate("");
    }

    void tprint(String str) {
        OperationFactory Fac = new OperationFactory();
        String[] command = str.toUpperCase().trim().replaceAll("\\s{2,}", " ").split(" ");
        try {
            IOperation op = Fac.makeOperation(command[0]);
            if (op != null) {
                op.operate(context, command);
            }
        } catch (InvalidNumberOfArgs | StackDepthException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException ignored) {}
    }

    @Test
    public void define_test() {
        tprint("define x 5\n"); // definition
        tprint("push x\n");
        tprint("pop\n");
        Assert.assertEquals("5.0\n", output.toString());
        output.reset();

        tprint("define x 55.1\n"); // redefinition
        tprint("push x\n");
        tprint("pop\n");
        Assert.assertEquals("55.1\n", output.toString());
        output.reset();

        tprint("define x 5\n"); // definition of several
        tprint("define x2 55\n");
        tprint("push x\n");
        tprint("push x2\n");
        tprint("pop\n");
        tprint("pop\n");
        Assert.assertEquals("55.0\n5.0\n", output.toString());
        output.reset();
    }

    @Test
    public void divide_test() {
        tprint("push 5\n");
        tprint("push 5\n");
        tprint("/\n");
        tprint("pop\n");
        Assert.assertEquals("1.0\n", output.toString());
        output.reset();

        tprint("push 55\n");
        tprint("push 11\n");
        tprint("/\n");
        tprint("pop\n");
        Assert.assertEquals("5.0\n", output.toString());
        output.reset();
    }

    @Test
    public void minus_test() {
        tprint("push 5\n");
        tprint("push 5\n");
        tprint("-\n");
        tprint("pop\n");
        Assert.assertEquals("0.0\n", output.toString());
        output.reset();

        tprint("push 5\n");
        tprint("push 7\n");
        tprint("-\n");
        tprint("pop\n");
        Assert.assertEquals("-2.0\n", output.toString());
        output.reset();
    }

    @Test
    public void multiply_test() {
        tprint("push 5\n");
        tprint("push 5\n");
        tprint("*\n");
        tprint("pop\n");
        Assert.assertEquals("25.0\n", output.toString());
        output.reset();

        tprint("push 5\n");
        tprint("push 11\n");
        tprint("*\n");
        tprint("pop\n");
        Assert.assertEquals("55.0\n", output.toString());
        output.reset();
    }

    @Test
    public void plus_test() {
        tprint("push 5\n");
        tprint("push 5\n");
        tprint("*\n");
        tprint("pop\n");
        Assert.assertEquals("25.0\n", output.toString());
        output.reset();

        tprint("push 5\n");
        tprint("push 11\n");
        tprint("*\n");
        tprint("pop\n");
        Assert.assertEquals("55.0\n", output.toString());
        output.reset();
    }

    @Test
    public void pop_test() {
        tprint("push 5\n");
        tprint("push 7\n");
        tprint("pop\n");
        Assert.assertEquals("7.0\n", output.toString());
        output.reset();

        tprint("push 5\n");
        tprint("push 11\n");
        tprint("define c 121\n");
        tprint("pop\n");
        Assert.assertEquals("11.0\n", output.toString());
        output.reset();

        tprint("push 5\n");
        tprint("push 11\n");
        tprint("define c 121\n");
        tprint("push c");
        tprint("pop\n");
        Assert.assertEquals("121.0\n", output.toString());
        output.reset();
    }

    @Test
    public void push_test() {
        // done above
    }

    @Test
    public void sqrt_test() {
        tprint("push 25\n");
        tprint("sqrt\n");
        tprint("pop\n");
        Assert.assertEquals("5.0\n", output.toString());
        output.reset();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
