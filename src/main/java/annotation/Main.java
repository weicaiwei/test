package annotation;

public class Main {

    public static void main(String[] args) {

        User user = UserFactory.create();
        System.out.println(user.getName()+"\r\n"+user.getAge());
    }
}
