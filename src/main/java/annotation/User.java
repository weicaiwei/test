package annotation;


public class User {


    @Init
    private String name;

    @Init("29")
    private String age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }
}
