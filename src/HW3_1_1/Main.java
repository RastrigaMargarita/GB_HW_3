package HW3_1_1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("Россия");
        al1.add("Греция");
        al1.add("Польша");
        al1.add("Чехия");

        System.out.println(changeElements(al1, 1, 3).toString());

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(2);
        al2.add(5);
        al2.add(9);
        al2.add(10);

        System.out.println(changeElements(al2, 1, 3).toString());

    }

    public static <T> ArrayList<T> changeElements(ArrayList<T> al, int i, int j) {
        T value;
        value = al.get(i);
        al.set(i, al.get(j));
        al.set(j, value);
        return al;
    }
}
