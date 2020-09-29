package HW3_4_1;

public class PrintLetter extends Thread {
    char letter;

    public PrintLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        synchronized (Main.mon) {
            try {
                //for (int i = 0; i < 5; i++) {
                    while (Main.currentLetter != letter) {
                        Main.mon.wait();
                    }
                    System.out.print(letter);
                    Main.currentLetter = (char) (Main.currentLetter == 67 ? 65 : Main.currentLetter+1);
                    Main.mon.notifyAll();
                //}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
