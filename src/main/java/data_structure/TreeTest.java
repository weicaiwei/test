package data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TreeTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/27 23:10
 */
public class TreeTest {

    public static void main(String[] args) {

    }

}
class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    private static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }
}
