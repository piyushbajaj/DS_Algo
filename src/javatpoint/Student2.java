package javatpoint;

/**
 * Created by piyush.bajaj on 14/03/16.
 */
public class Student2 {
    int rollno;
    String name;

    public static void main(String args[]) {
        Student2 s1 = new Student2();
        Student2 s2 = new Student2();

        s1.insertRecord(111, "Karan");
        s2.insertRecord(222, "Aryan");

        s1.displayInformation();
        s2.displayInformation();

    }

    void insertRecord(int r, String n) {  //method
        rollno = r;
        name = n;
    }

    void displayInformation() {
        System.out.println(rollno + " " + name);
    }//method
}
