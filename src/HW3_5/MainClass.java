package HW3_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cb;
    public static Semaphore smp;
    public static CountDownLatch cdl;
    //  public static CountDownLatch cdl1;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        cb = new CyclicBarrier(CARS_COUNT);
        smp = new Semaphore(Math.round(CARS_COUNT / 2));
        cdl = new CountDownLatch(CARS_COUNT);
        // cdl1 = new CountDownLatch(1);

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();

        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdl = new CountDownLatch(CARS_COUNT);
        try {


            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
