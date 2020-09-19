package HW3_1_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] mas1 = new String[]{"Россия", "Греция", "Польша", "Чехия"};

        System.out.println(changeMassive(mas1).toString());

        Integer[] mas2 = new Integer[]{1, 2, 3, 4444};

        System.out.println(changeMassive(mas2).toString());

    }

    public static <T> ArrayList<T> changeMassive(T[] mas) {
        ArrayList<T> al = new ArrayList<>();
        for (T element : mas
        ) {
            al.add(element);

        }
        return al;
    }
}

