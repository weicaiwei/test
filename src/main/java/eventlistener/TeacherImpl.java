package eventlistener;

import java.util.*;

public class TeacherImpl implements Teacher {

    Map<String,String> studentsHomework;

    @Override
    public void receiveHomework(String studentName, String homework) {
        studentsHomework.put(studentName, homework);
    }

    @Override
    public void checkHomework() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String studentName : studentsHomework.keySet()) {
            stringBuffer.append("已查看。。。");
            stringBuffer.append(studentsHomework.get(studentName));
            stringBuffer.append("  你的得分是："+Integer.valueOf(new Random().nextInt(100)).toString());
            studentsHomework.put(studentName, stringBuffer.toString());
            System.out.println(studentName+"作业已经检查完毕");
            stringBuffer.delete(0, stringBuffer.length());

        }

    }

    @Override
    public String getStudentScore(String studentName) {
        return studentsHomework.get(studentName);
    }

    public TeacherImpl() {
        studentsHomework = new HashMap<>();
    }


}
