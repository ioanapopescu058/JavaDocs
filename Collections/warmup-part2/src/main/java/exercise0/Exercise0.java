package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("Cat", "Molly");
        myMap.put("Dog", "Ginger");
        myMap.put("Hamster", "Bosco");

        // Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]

        Set<String> keySet = myMap.keySet();
        //System.out.println(myMap);

        for (String s : keySet) {
            System.out.println(s + "=" + myMap.get(s));
        }
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
