package stack;

/**
 * 栈的简单链式实现
 *
 * @author llliujw
 */
public class LinkedStack implements Stack {

    /**
     * 头节点,第一个元素之前的节点
     */
    private Node top;

    /**
     * 大小
     */
    private int size;

    @Override
    public void push(Integer value) {
        top = new Node(value, top);
        size++;
    }

    @Override
    public Integer pop() {
        if (top == null || size == 0) throw new RuntimeException("Stack is Empty");
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    @Override
    public Integer top() {
        if (top == null || size == 0) return null;
        return top.value;
    }

    private static class Node {
        Integer value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
