package thinking_in_java_study.chapter_1;

/**
 * @Name: Main
 * @Description: 第一章的主测试入口类
 * @auther: caiwei
 * @date: 2019/12/17 22:32
 */
public class Main {

    public static void main(String[] args) {



        //对象的引用类型决定了对象作为什么对象来进行处理，即使new的子类型对象，
        // 但引用是父类型的引用，也不能调用子类的锁特有的方法，若要调用，得先强制转型成子对象
        //强制类型转换，在Java中由于继承和向上转型，子类可以非常自然地转换成父类，但是父类转换成子类则需要强制转换
        // 但是当引用类型的真实身份是父类本身的类型时，强制类型转换编译时不会产生错误，但是运行时就会产生错误，
        // 当2个对象没有继承关系时，强制类型转换在编译时就会产生错误会产生错误（可能是idea检查的多，用eclipse貌似未报错（存疑））
        Father father1 = new Father();
        father1.sayToSon();


        Father father2 = new Son();
        father2.sayToSon();

        Son son = new Son();
        son.sayToSon();


        Father father3 = new Father();
        ((Son) father3).saySelf();

        Father obj = new Father();
        //String strVal = (String)obj;//错误
    }
}

