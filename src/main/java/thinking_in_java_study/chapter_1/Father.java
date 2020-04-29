package thinking_in_java_study.chapter_1;

/**
 * @Name: Father
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/12/17 23:46
 */
public class Father{
    private String name ="来自父类对象";

    protected void sayToSon() {
        System.out.println("爸爸在说话呢");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
