package Javatpoint;

/**
 * Created by piyush.bajaj on 25/11/16.
 */


interface Printable {
    void print();
}

interface Showable {
    void show();
}

public class interface_demo implements Printable, Showable {

    public static void main(String args[]) {
        interface_demo obj = new interface_demo();
        obj.print();
        obj.show();
    }

    public void print() {
        System.out.println("Hello");
    }

    public void show() {
        System.out.println("Welcome");
    }
}

