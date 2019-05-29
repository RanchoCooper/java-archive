package com.baeldung.customer_junit4_test_runners;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

/**
 * @author rancho
 * @date 2019-05-29
 */
public class CustomerRunner extends Runner {

    private Class testedClass;

    public CustomerRunner(Class testedClass) {
        super();
        this.testedClass = testedClass;
    }

    /**
     * implements Describable interface
     * @return Description
     */
    @Override
    public Description getDescription() {
        return Description.createTestDescription(testedClass, "A Customer runner");
    }

    /**
     * invoke the target tested methods using reflection
     * @param notifier used for firing events that have information about the test progress
     */
    @Override
    public void run(RunNotifier notifier) {
        System.out.println("running thr tests based on CustomerRunner" + testedClass);

        try {
            Object testedObject = testedClass.newInstance();
            for (Method method : testedClass.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    notifier.fireTestStarted(Description.createTestDescription(testedClass, method.getName()));
                    method.invoke(testedObject);
                    notifier.fireTestFinished(Description.createTestDescription(testedClass, method.getName()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
