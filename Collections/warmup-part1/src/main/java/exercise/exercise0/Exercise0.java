package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    ArrayList<Integer> list;

    public Exercise0(){
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> it = list.listIterator();
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        int j = 0;
        for (Integer i : list) {
            System.out.print(list.get(j) + " ");
            j++;
        }
        System.out.println();
        while(it.hasNext()) {
            Integer in = it.next();
            System.out.print(in + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex0 = new Exercise0();
        ex0.iterateThroughList();
    }
}
