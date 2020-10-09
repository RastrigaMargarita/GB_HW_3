package HW3_7;

import java.lang.reflect.Method;

public class Pair implements Comparable {
    int value;
    Method method;

    public Pair(int value, Method method) {
        this.method = method;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return value - ((Pair) o).value;
    }
}
