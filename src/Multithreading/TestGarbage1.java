package Multithreading;

/**
 * Created by piyush.bajaj on 23/09/16.
 */
public class TestGarbage1 {
    public static void main(String[] args) {
        TestGarbage1 s1 = new TestGarbage1();
        TestGarbage1 s2 = new TestGarbage1();
        s1 = null;
        s2 = null;
        System.gc();
    }

    public void finalize() {
        System.out.println("object is garbage collected");
    }
}
