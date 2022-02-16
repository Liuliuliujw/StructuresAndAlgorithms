package list;

import java.util.Iterator;

/**
 * 表的简单实现（双链表）
 *
 * @author llliujw
 */
public class DoublyLinkedList implements List {

    /**
     * 大小
     */
    int size;

    /**
     * 头节点(第一个节点之前)
     */
    Node head;

    /**
     * 尾节点（最后一个节点之后）
     */
    Node tail;

    DoublyLinkedList() {
        size = 0;
        head = new Node(0, null, null);
        tail = new Node(0, null, null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void insert(int pos, Integer value) {
        if (size + 1 - pos < 0 || pos < 0) return;
        Node temp = head;
        while (pos-- > 0) temp = temp.next;
        Node node = new Node(value, temp, temp.next);
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    @Override
    public void append(Integer value) {
        Node node = new Node(value, tail.prev, tail);
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    @Override
    public Integer get(int pos) {
        if (size + 1 - pos < 0 || pos < 0) return null;
        Node temp = head;
        while (pos-- > 0) temp = temp.next;
        return temp.next.value;
    }

    @Override
    public void modify(int pos, Integer value) {
        if (size + 1 - pos < 0 || pos < 0) return;
        Node temp = head;
        while (pos-- > 0) temp = temp.next;
        temp.next.value = value;
    }

    @Override
    public void remove(int pos) {
        if (size + 1 - pos < 0 || pos < 0) return;
        Node temp = head;
        while (pos-- > 0) temp = temp.next;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) return;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 获取迭代器
     *
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iter(head);
    }

    /**
     * 节点
     */
    private static class Node {
        private int value;
        private Node prev;
        private Node next;

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 迭代器
     */
    private static class Iter implements Iterator<Integer> {

        private Node temp;

        Iter(Node head) {
            this.temp = head;
        }

        @Override
        public boolean hasNext() {
            return temp.next.next != null;
        }

        @Override
        public Integer next() {
            int value = temp.next.value;
            temp = temp.next;
            return value;
        }
    }
}
