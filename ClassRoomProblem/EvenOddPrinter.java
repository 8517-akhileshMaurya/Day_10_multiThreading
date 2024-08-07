package ClassRoomProblem;

public class EvenOddPrinter {
    private static final Object lock = new Object();
    private static int  CurrentNumber = 1;
    private static int MAX_NUMBER = 20;

    public static void main(String[] args) {
        Thread evenTread = new Thread(EvenOddPrinter::PrintEvenNumber);
        Thread oddThread = new Thread(EvenOddPrinter::PrintOddNumber);
        evenTread.start();
        oddThread.start();
    }


    private static void PrintEvenNumber(){
        while(CurrentNumber <= MAX_NUMBER){
            synchronized (lock){
                if(CurrentNumber % 2 ==0){
                    System.out.println("Even :" + CurrentNumber);
                    CurrentNumber++;
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private static void PrintOddNumber(){
        while (CurrentNumber<=MAX_NUMBER){
            synchronized (lock){
                if(CurrentNumber % 2 == 1){
                    System.out.println("Odd " + CurrentNumber);
                    CurrentNumber++;
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}

