package com.example.openapispringboot.services;

import com.example.openapispringboot.entities.Task;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Slf4j
public class ThreadPoolService {

    private final ExecutorService threadPool;

    private final Map<String, Future> taskManager;

    public ThreadPoolService() {
        threadPool = Executors.newFixedThreadPool(50);
        taskManager = new HashMap<>();
    }

    public void executeTask(Task task) {
        log.info("Start execute task {}", task.getId());
        int i = 0;
        while (!task.getFuture().isDone()) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ignored) {
            }
            log.info("Task {} running {}", task.getId(), ++i);
        }
        log.info("Task {} done", task.getId());
    }

    public Task addTask(Task task) {
        task.setId(new ObjectId().toHexString());
        Future future = threadPool.submit(() -> executeTask(task));

        task.setFuture(future);
        taskManager.put(task.getId(), future);
        return task;
    }

    public boolean killTask(String id) {
        Future future = taskManager.get(id);
        return future.cancel(true);
    }

}
