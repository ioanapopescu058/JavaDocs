package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ioana.Popescu on 7/7/2017.
 */

public class Student {

    String firstName;
    String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

class StudentExtension1 extends Student{

        public StudentExtension1(String firstName, String lastName) {
            super(firstName, lastName);
        }

        @Override
        public boolean equals(Object o) {
            StudentExtension1 student = (StudentExtension1) o;
            return firstName.equals(student.firstName);
        }

        @Override
        public int hashCode() {
            return firstName.hashCode();
        }
}

class StudentExtension2 extends Student {

    public StudentExtension2(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        StudentExtension2 student = (StudentExtension2) o;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }
}

class StudentExtension3 extends Student{

    public StudentExtension3(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        StudentExtension3 student = (StudentExtension3) o;
        if (!firstName.equals(student.firstName))   return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode() + lastName.hashCode();
        return result;
    }
}

class StudentExtension4 extends Student {

    public StudentExtension4(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        StudentExtension4 student = (StudentExtension4) o;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode() + lastName.hashCode();
        return result;
    }
}

//Now create another class that suits the main() method where we create 4 MAPS where the KEY will be of type STUDENT
// and the VALUE will be a BigDecimal representing the age (or whatever).
//In the first Map, the key will be an object from point (a), in the second map it will be an object from point (b),
// in the third map it will be an object from point (c) and in the last map it be an object from point (d).
//Think and set the proper properties for the objects in order to observe what can go wrong with our dictionaries.

class Main {
    public static void main(String[] args) {
        Map<Student, BigDecimal> studMap1 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> studMap2 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> studMap3 = new HashMap<Student, BigDecimal>();
        Map<Student, BigDecimal> studMap4 = new HashMap<Student, BigDecimal>();

        StudentExtension1 s1 = new StudentExtension1("Maria", "Popa");
        StudentExtension1 s12 = new StudentExtension1("Maria", "Popescu");

        StudentExtension2 s2 = new StudentExtension2("Ioana", "Dumitru");
        StudentExtension2 s22 = new StudentExtension2("Ioana", "Dumitru");

        StudentExtension3 s3 = new StudentExtension3("Alin", "Ionescu");

        StudentExtension4 s4 = new StudentExtension4("George", "Marin");
        StudentExtension4 s42 = new StudentExtension4("George", "Marin");
        StudentExtension4 s43 = new StudentExtension4("Alex", "Popa");

        studMap1.put(s1, new BigDecimal("20"));
        studMap1.put(s12, new BigDecimal("20"));

        studMap2.put(s2, new BigDecimal("21"));
        studMap2.put(s22, new BigDecimal("21"));

        studMap3.put(s3, new BigDecimal("22"));

        studMap4.put(s4, new BigDecimal("23"));
        studMap4.put(s42, new BigDecimal("20"));
        studMap4.put(s43, new BigDecimal("21"));

        System.out.println(studMap1);
        System.out.println(studMap2);
        System.out.println(studMap3);
        System.out.println(studMap4);
    }
}
