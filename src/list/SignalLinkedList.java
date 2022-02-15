package list;

import java.util.Iterator;

/**
 * 表的简单实现（单链表）
 *
 * @author llliujw
 */
public class SignalLinkedList implements List {

    /**
     * 头节点,第一个元素之前的节点
     */
    private final Node head;

    /**
     * 大小
     */
    private int size;

    SignalLinkedList() {
        head = new Node(0);
        size = 0;
    }

    @Override
    public void insert(int pos, Integer value) {
        if (size + 1 - pos < 0 || pos < 0) return;
        Node temp = head;
        //使temp指向插入位置的前一个节点
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        //构建插入值的新节点
        Node newValue = new Node(value);
        //新节点的next指向插入位置上一节点的next
        newValue.next = temp.next;
        //插入位置的上一个节点的next指向新节点
        temp.next = newValue;
        size++;
    }

    @Override
    public void append(Integer value) {
        Node temp = head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        //插入新值
        temp.next = new Node(value);
        size++;
    }

    @Override
    public Integer get(int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.next.value;
    }

    @Override
    public void modify(int pos, Integer value) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        temp.next.value = value;
    }

    @Override
    public void remove(int pos) {
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        //使被删除节点的上一节点的next指向删除节点的next
        temp.next = temp.next.next;
        size--;
    }

    @Override
    public void removeLast() {
        Node temp = head;
        //找到尾节点
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter(head);
    }

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private static class Iter implements Iterator<Integer> {

        Node temp;

        Iter(Node head) {
            this.temp = head;
        }

        @Override
        public boolean hasNext() {
            return temp.next != null;
        }

        @Override
        public Integer next() {
            int value = temp.next.value;
            temp = temp.next;
            return value;
        }
    }
}
