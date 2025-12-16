package com.example.flowable;

import org.flowable.engine.RuntimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements CommandLineRunner {

    private final RuntimeService runtimeService;

    public SampleRunner(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            runtimeService.startProcessInstanceByKey("simpleProcess");
            System.out.println("Started sample process 'simpleProcess'");
        } catch (Exception e) {
            System.err.println("Could not start process: " + e.getMessage());
        }
    }
}
