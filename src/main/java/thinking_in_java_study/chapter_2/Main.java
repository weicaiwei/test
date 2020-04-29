package thinking_in_java_study.chapter_2;

import thinking_in_java_study.chapter_1.Father;

/**
 * @Name: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/17 23:46
 */
public class Main {

    public static void main(String[] args) {

        char aChar = '采';
        System.out.println(aChar);

        String name = "采薇薇";//Java中，字符（char）用单引号表示，字符串（string）用双引号表示
        StringBuilder stringBuilder = new StringBuilder();

        for(char aaChar :name.toCharArray() ){
            stringBuilder.append(aaChar).append(",");
        }
        System.out.println(stringBuilder);

        Father father = new Father();
        //father.sayToSon();//因为该方法被protected字段修饰，所以在包外无法引用


        InitTest initTest = new InitTest();
        System.out.println(initTest.aBoolean);
        System.out.println(initTest.aChar );
        System.out.println(initTest.aByte);
        System.out.println(initTest.aShort);
        System.out.println(initTest.anInt);
        System.out.println(initTest.aLong);
        System.out.println(initTest.aFloat);
        System.out.println(initTest.aDouble);
        System.out.println(initTest.father);
        //echo:
        //false
        // //是‘\u0000’,显示像空格，其实不是空格
        //0
        //0
        //0
        //0
        //0.0
        //0.0
        //null
        initTest.test();//调用方法，通常称为发送消息给对象，该例中，对象时initTest,消息是test(),
        //面向对象的程序设计通常简单地归纳为“向对象发送消息”
    }

}
