package Javatpoint;

/**
 * Created by piyush.bajaj on 24/02/17.
 */
public class test {
    static String college = "ITS";

    static {
        System.out.println("aa");

    }

    int rollNo;
    String name;

    test(int r, String n) {
        rollNo = r;
        name = n;
    }

    public static void change() {
        college = "BBDIT";
    }

    public static void main(String[] args) {

        try {
            int a[] = new int[5];
            a[5] = 30 / 0;
        } catch (ArithmeticException e) {
            System.out.println("task1 is completed");
            int a[] = new int[5];
            a[5] = 30 / 0;

            System.out.println("task1 is completed");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("task 2 completed");
        } catch (Exception e) {
            System.out.println("common task completed");
        }


        change();
        test s1 = new test(111, "Karan");
        test s2 = new test(222, "Aryan");
        test s3 = new test(333, "Sonoo");

        s1.display();
        s2.display();
        s3.display();
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}
