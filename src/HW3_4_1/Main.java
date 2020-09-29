package HW3_4_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static volatile char currentLetter;
    public static final Object mon = new Object();

    public static void main(String[] args) {
        currentLetter = 65;
//        (new PrintLetter((char) 65)).start();
//        (new PrintLetter((char) 66)).start();
//        (new PrintLetter((char) 67)).start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new PrintLetter((char) 65));
            executorService.execute(new PrintLetter((char) 66));
            executorService.execute(new PrintLetter((char) 67));
        }
        executorService.shutdown();

    }


}
