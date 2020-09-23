package HW3_1_3;


public class Apple implements Fruit {
    float weight;

    public Apple() {
        this.weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
