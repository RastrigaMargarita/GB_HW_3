package HW3_1_3;

public class Main {
    public static void main(String[] args) {
        Box<Apple> boxWithApples = new Box();
        for (int i = 0; i < 9; i++) {
            boxWithApples.Put(new Apple());
        }
        //boxWithApples.Put(new Orange());//<-получаем ошибку

        Box<Orange> boxWithOranges = new Box();
        for (int i = 0; i < 5; i++) {
            boxWithOranges.Put(new Orange());
        }

        System.out.println("Коробка с яблоками весит " + boxWithApples.getWeight());
        System.out.println("Коробка с апельсинами весит " + boxWithOranges.getWeight());

        Box<Orange> boxWithOranges2 = new Box();
        for (int i = 0; i < 6; i++) {
            boxWithOranges2.Put(new Orange());
        }

        System.out.println("Другая коробка с апельсинами весит " + boxWithOranges2.getWeight());

        System.out.println("Коробки 1 и 2 весят одинаково: " + boxWithApples.compare(boxWithOranges));
        System.out.println("Коробки 2 и 3 весят одинаково: " + boxWithOranges.compare(boxWithOranges2));
        System.out.println("Коробки 1 и 3 весят одинаково: " + boxWithApples.compare(boxWithOranges2));

        //transfer(boxWithApples, boxWithOranges); //<-получаем ошибку
        transfer(boxWithOranges, boxWithOranges2);
        System.out.println("Теперь первая коробка с апельсинами весит " + boxWithOranges.getWeight());
        System.out.println("Теперь вторая коробка с апельсинами весит " + boxWithOranges2.getWeight());
    }


    public static <T extends Fruit> void transfer(Box<T> b1, Box<T> b2) {
        for (T fruit : b1.listFruits
        ) {
            b2.Put(fruit);
        }
        b1.listFruits.clear();
    }
}
