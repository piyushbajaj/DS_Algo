package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 2: Class implementing interfaces
 */
public class Circle implements Shape {
    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}
