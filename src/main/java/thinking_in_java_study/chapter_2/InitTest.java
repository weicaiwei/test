package thinking_in_java_study.chapter_2;

import thinking_in_java_study.chapter_1.Father;

/**
 * @Name: InitTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/18 21:40
 */
public class InitTest {

    boolean aBoolean;
    char aChar;
    byte aByte;
    short aShort;
    int anInt;
    long aLong;
    float aFloat;
    double aDouble;
    Father father;

    void test() {
        int i;
        System.out.println("hello"/*+i*/);//成员变量，如果未手动初始化，编译器会给他自动赋值，
        // 基本类型赋值false,\u0000,0,0.0等，对象类型赋值为null,即未指向任何堆中的对象
    }



    String methodSignature(String name) {
        return name;
    }

    /*void methodSignature(String name) { }*/
    //方法名和参数列表合起来构成方法签名，用来唯一地标识出该方法，返回值不是方法签名的一部分

    String methodSignature(String name,String otherName) {
        return name;
    }
}
