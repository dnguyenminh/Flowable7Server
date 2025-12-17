package com.example.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.concurrent.atomic.AtomicInteger;

public class TestFailingDelegate implements JavaDelegate {

    // static counter so test can control behavior across job retries
    public static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void execute(DelegateExecution execution) {
        int c = counter.getAndIncrement();
        if (c == 0) {
            // fail the first execution to generate retry behavior
            throw new RuntimeException("expected failure for test");
        }
        // succeed on subsequent executions
        execution.setVariable("delegateExecuted", true);
    }
}
