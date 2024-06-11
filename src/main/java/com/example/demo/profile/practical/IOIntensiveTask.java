package com.example.demo.profile.practical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class IOIntensiveTask {
    static final Logger logger = Logger.getLogger(IOIntensiveTask.class.getName());

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);

        /* CachedThreadPool Executors.newCachedThreadPool()
           ScheduledThreadPool
           SingleThreadedExecutor
         */
        for (int i = 0; i < 100; i++) {
            service.execute(new IOIntensiveTask.Example());
        }
    }

    static class Example implements Runnable {
        @Override
        public void run() {
            // TODO IO Intensive Task
            logger.info("In run");
        }
    }

}
