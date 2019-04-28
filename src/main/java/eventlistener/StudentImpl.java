package eventlistener;

import java.util.Random;


public class StudentImpl implements Student {

    private String name;

    private Teacher teacher;

    private String homework;

    static String[] strings = {"我", "在", "学", "习", "母", "猪", "的", "产", "后", "护", "理"};


    @Override
    public void doingHomework() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(strings[new Random().nextInt(6)]);
        }
        homework = stringBuilder.toString();
    }

    @Override
    public void handInHomework() {
        teacher.receiveHomework(name,homework);
        System.out.println(name + "已经交作业了,玩去了");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lookScore() {
        System.out.println("我" + "(" + name + ")" + "成绩是" + teacher.getStudentScore(name));
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setName() {
        this.name = name;
    }


    public StudentImpl() {}



    public StudentImpl(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
}
