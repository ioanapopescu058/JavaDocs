package ro.teamnet.zerotohero.exceptions;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
class ExceptionPropagation {

    void method3() {
        int result = 100 / 0;  //Exception Generated
    }

    void method2() {
        method3();
    }

    void method1() throws MyException {
        try {
            method2();
        } catch (Exception e) {
            System.out.println("Exception is handled here");
            throw new MyException( "Other IOException");
        }
    }
}
