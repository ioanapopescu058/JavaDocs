package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
enum UserStatus {
    PENDING,
    ACTIVE,
    INACTIVE,
    DELETED;
}
class SuperSuperClass {
    public String toString() {
        return "SuperSuperClass";
    }
}

class SuperClass extends SuperSuperClass{
    public Integer k;

    public String toString() {
        return "SuperClass";
    }

    public void inheritedMethod() {
        System.out.println("Inherited method");
    }
}
class MyClass extends SuperClass{
    public String s;
    public Boolean ok;
    private Integer i;

    class Class1 {

    }

    class Class2 {

    }

    MyClass() {
        s = "alabala";
    }
    MyClass(String s) {
        this.s = s;
    }
    public String toString() {
        return "MyClass";
    }
    public void methodA() {
       // System.out.println("MethodA");
    }
}

public class ClassReflectionDemoMain {
    public static void main(String[] args) throws Exception{
        // get the class for a String object, and print it
        Class stringClass = "string".getClass();
        System.out.println(stringClass.getName());

        // get the class of an Enum, and print it
        Class enumClass = UserStatus.PENDING.getClass();
        System.out.println(enumClass);

        // get the class of a collection, and print it
        Class collClass = (new HashMap()).getClass();
        System.out.println(collClass);

        // get the class of a primitive type, and print it
        int i = 20;
        System.out.println(Integer.valueOf(i).getClass().getTypeName());

        // get and print the class for a field of primitive type
        MyClass myclass = new MyClass();
        Field f = MyClass.class.getDeclaredField("s");
        String fieldValue = (String)f.get(myclass);
        System.out.println("fieldValue = " + fieldValue);


        // get and print the class for a primitive type, using the wrapper class
        Class wrapperClass = Boolean.TYPE;
        System.out.println(wrapperClass);

        // get the class for a specified class name
        Class classClass = Class.forName("ro.teamnet.zerotohero.reflection.MyClass");
        System.out.println(classClass);

        // get the superclass of a class, and print it
        // get the superclass of the superclass above, and print it
        Class superClass = MyClass.class.getSuperclass();
        Class superSuperClass = superClass.getSuperclass();
        System.out.println(superClass);
        System.out.println(superSuperClass);

        // get and print the declared classes within some other class
        MyClass cls = new MyClass();
        Class[] classes = cls.getClass().getDeclaredClasses();
        for (Class cl : classes) {
            System.out.println(cl);
        }

        // print the number of constructors of a class
        int n = MyClass.class.getDeclaredConstructors().length;
        System.out.println(n);

        // get and invoke a public constructor of a class
        MyClass myClass = (MyClass)MyClass.class.getDeclaredConstructor(String.class).newInstance("ceva");
        System.out.println(myClass.s);

        // get and print the class of one private field
        Field fieldType = MyClass.class.getDeclaredField("i");
        System.out.println(fieldType.getType());
		
		// set and print the value of one private field for an object
        MyClass myprivateclass = new MyClass();
        Field field = myprivateclass.getClass().getDeclaredField("i");
        field.setAccessible(true);
        field.set(myprivateclass, 4);
        System.out.println(field.get(myprivateclass));

        // get and print only the public fields class
        Field[] fld = MyClass.class.getFields();
        for (Field k : fld) {
            System.out.println(k);
        }

        // get and invoke one public method of a class
        Method method = MyClass.class.getDeclaredMethod("methodA");
        method.invoke(new MyClass());

        // get and invoke one inherited method of a class
        Method methodSuperClass = MyClass.class.getMethod("inheritedMethod");
        methodSuperClass.invoke(new MyClass());
		
		// invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
		// invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
		MyClass classic = new MyClass();
		int l = 10000;
		long start1 = System.currentTimeMillis();
		while (l > 0) {
		    classic.methodA();
		    l--;
        }
        long end1 = System.currentTimeMillis();
		long res1 = end1 - start1;
		System.out.println("Result for the classic invoke: " + res1);

        Method reflection = MyClass.class.getDeclaredMethod("methodA");
        int m = 10000;
        long start2 = System.currentTimeMillis();
        while (m > 0) {
            reflection.invoke(new MyClass());
            m--;
        }
        long end2 = System.currentTimeMillis();
        long res2 = end2 - start2;
        System.out.println("Result for the reflection invoke: " + res2);
    }
}
