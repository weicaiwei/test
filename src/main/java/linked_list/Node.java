package linked_list;

/**
 * @ClassName: Node
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/18 17:00
 */
public class Node<T> {
    private T data;
    Node next;
    public Node() { }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
