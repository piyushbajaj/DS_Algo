package Array;

import java.util.HashMap;

import javatpoint.Student;

/**
 * Created by piyush.bajaj on 16/11/16.
 */
public class Hashing {

    public HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s : students) {
            map.put(s.getId(), s);
        }
        return map;

        //String s;
        //s.con
    }

//    public static void main(String[] args) {
//        Hashing h = new Hashing();
//        String[] S = {"Piyush", "Yash", "Himanshu"};
//        h.buildMap(S);
//    }

}
