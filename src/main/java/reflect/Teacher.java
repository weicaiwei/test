package reflect;

import lombok.Data;

/**
 * @ClassName: Teacher
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/21 19:07
 */
@Data
public class Teacher {

    private String name;

    public Teacher() {
        System.out.println("一个老师出现啦");
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String hit(String student) {
        System.out.println("方法中，" + name + "老师打" + student);
        return name + "老师打" + student;
    }


    public void hit2(String student) {
        System.out.println("方法中，" + name + "老师打" + student+";没有返回值");

    }


    
}
