package ro.teamnet.zerotohero.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */


public class Foo {

    public Foo() throws MyException {
        throw new MyException("try again please");
    }

    static String readFirstLineFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ioana.popescu\\IdeaProjects\\JavaProject\\src\\ro\\teamnet\\zerotohero\\exceptions\\file.txt"))) {
            return br.readLine();
        }
        catch(IOException e){
            System.err.println("error open file");
            return "";
        }
    }

    static String readFirstLineFromFileWithFinally() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ioana.popescu\\IdeaProjects\\JavaProject\\src\\ro\\teamnet\\zerotohero\\exceptions\\file.txt"));
        try {
            return br.readLine();
        }
        catch(IOException e){
            System.err.println("error open file");
            return "";
        }
        finally {
            if (br != null) br.close();
        }
    }

    static String readFirstLineFromFileMultiCatch() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ioana.popescu\\IdeaProjects\\JavaProject\\src\\ro\\teamnet\\zerotohero\\exceptions\\file.txt"))) {
            return br.readLine();
        }
        catch(IOException | ArithmeticException e){
            System.err.println("error open file");
            return "";
        }
    }

    static String readFirstLineFromFileMultiExc() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ioana.popescu\\IdeaProjects\\JavaProject\\src\\ro\\teamnet\\zerotohero\\exceptions\\file.txt"))) {
            return br.readLine();
        }
        catch(IOException e) {
            System.err.println("error open file");
            return "";
        }
        catch(ArithmeticException e){
            System.err.println("error open file");
            return "";
        }
    }

    public static void main(String[] args) throws MyException, IOException{

        //Foo foo1 = new Foo();

        /*ExceptionPropagation obj = new ExceptionPropagation();
        obj.method1();
        System.out.println("Continue with Normal Flow...");*/

        String s1 = readFirstLineFromFile();
        System.out.println(s1);

        String s2 = readFirstLineFromFileWithFinally();
        System.out.println(s2);
    }
}
