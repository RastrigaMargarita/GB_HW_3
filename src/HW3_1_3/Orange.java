package HW3_1_3;

public class Orange implements Fruit {
    float weight;

    public Orange() {
        this.weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
