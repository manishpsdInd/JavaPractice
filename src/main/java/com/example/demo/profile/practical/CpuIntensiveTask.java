package com.example.demo.profile.practical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class CpuIntensiveTask {

    static final Logger logger = Logger.getLogger(CpuIntensiveTask.class.getName());

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        for (int i = 0; i < 100; i++) {
            service.execute(new Example());
        }
    }

    static class Example implements Runnable {
        @Override
        public void run() {
            // TODO Cpu Intensive Task
            logger.info("In run");
        }
    }

}
