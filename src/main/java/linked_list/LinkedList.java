package linked_list;

/**
 * @ClassName: LinkedList
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/11/18 17:40
 */
public class LinkedList<T> {

    //头节点
    private Node<T> head;

    //尾节点
    private Node<T> tail;

    //链表长度
    private int length;

    public LinkedList() {
        head = null;
        tail = null;
    }

    //获取链表长度
    public int getLength() {
        return length;
    }

    //检查链表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    //清空链表
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    //通过索引获取元素
    public Node getNodeByIndex(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        Node node = head;
        for (int i = 0; i < length; i++,node = node.next) {
            if (i == index) {
                return node;
            }
        }
        return null;
    }

    //头部插入
    public void addAtHead(T element) {

        head = new Node<>(element, head);
        //如果是空链表，就让尾指针指向头指针
        if (tail == null) {
            tail = head;
        }
        length++;
    }

    //尾部插入
    public void addAtTail(T element) {
        if (head == null) {
            head = new Node<>(element, null);
            tail = head;
        }
        Node<T> node = new Node<>(element, null);
        tail.next = node;
        tail = node;
        length++;
    }

    //在指定位置插入元素
    public void insert(T element, int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (index == 0) {
            addAtHead(element);
        } else if (index > 0 && index < length - 1) {
            //中间插入
            Node<T> insertNode = new Node<>(element, null);
            Node nextNode = getNodeByIndex(index);
            Node prevNode = getNodeByIndex(index - 1);
            prevNode.next = insertNode;
            insertNode.next = nextNode;
            length++;
        }else {
            addAtTail(element);
        }

    }
}
