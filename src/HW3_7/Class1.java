package HW3_7;

import HW3_7.annotation.Test;

public class Class1 extends ClassAbs {

    @Test(value = 6)
    public void method1() {
        print(getClass().getName() + ".method1, value 6");
    }

    @Test(value = 9)
    public void method2() {
        print(getClass().getName() + ".method2, value 9");
    }

    @Test(value = 2)

    private void method3() {
        print(getClass().getName() + ".method3, value 2");
    }

    @Test
    public void method4() {
        print(getClass().getName() + ".method4 value default");
    }
}
