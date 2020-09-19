package HW3_1_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> listFruits;

    public Box() {
        listFruits = new ArrayList<>();
    }

    public void Put(T fruit) {
        listFruits.add(fruit);
    }

    public float getWeight() {
        float sum = 0;
        for (T fruit : listFruits
        ) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> compareBox) {
        if (Math.abs(this.getWeight() - compareBox.getWeight()) < 0.00001) {
            return true;
        } else {
            return false;
        }

    }


    public void remove(T fruit) {
        listFruits.remove(fruit);
    }

}
