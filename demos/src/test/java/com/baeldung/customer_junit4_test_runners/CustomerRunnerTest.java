package com.baeldung.customer_junit4_test_runners;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author rancho
 * @date 2019-05-29
 */
@RunWith(CustomerRunner.class)
public class CustomerRunnerTest {

    Calculator calculator = new Calculator();

    @Test
    public void testCalculator() {
        System.out.println("start Calculator");
        assertEquals("addition", 8, calculator.add(5, 3));
    }

}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
