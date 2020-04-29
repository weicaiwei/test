package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @auther caiwei
 * @date 2020-04-20
 */
public class Test {

    public static void main(String[] args) {
        Task task = new Task();
        task.setNo("10001");
        task.setStatus(true);
        Map<String, Task> taskMap = new HashMap<>();
        taskMap.put(task.getNo(), task);
        System.out.println(taskMap.get("10001"));
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        System.out.println(taskList.get(0));
        taskMap.get("10001").setStatus(false);
        System.out.println(taskMap.get("10001"));
        System.out.println(taskList.get(0));



    }
}
