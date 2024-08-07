package Threading;

class myTask implements Runnable{
    public void run(){
        try{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("working.....");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Intrupped...");
        }
    }
}

public class ThreadInterruptionDemo {
    public static void main(String[] args) {
           Thread myThread = new Thread(new myTask());
           myThread.start();
           try {
               Thread.sleep(5000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }

           myThread.interrupt();
    }
}
