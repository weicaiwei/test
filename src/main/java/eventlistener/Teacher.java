package eventlistener;

public interface Teacher {

    void receiveHomework(String studentName, String homework);

    void checkHomework();

    String getStudentScore(String studentName);
}
