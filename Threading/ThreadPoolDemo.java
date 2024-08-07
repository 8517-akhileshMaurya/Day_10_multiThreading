package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int poolSize = 10;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < 20; i++) {
            executor.submit(new MyTask(i));
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private final int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
    }
}
