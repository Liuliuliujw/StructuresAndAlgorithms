package queue;

/**
 * 利用链式结构实现变长队列
 *
 * @author llliujw
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;

    LinkedQueue() {
        head = tail = null;
    }

    @Override
    public boolean enqueue(E e) {
        Node<E> node = new Node<>(e);
        if (tail == null) { //若队空，使队头队尾均指向新节点的引用
            head = tail = node;
        } else {    //若队非空，使队尾的下一节点指向新节点 并 移动队尾引用指向
            tail.next = node;
            tail = node;
        }
        return true;
    }

    @Override
    public E dequeue() {
        //队空返回null
        if (head == null) return null;
        //出队
        E e = head.data;
        if (head.next == null) head = tail = null; //若队空 使 队头队尾均为null
        else head = head.next; //移动队头引用指向
        return e;
    }

    @Override
    public E peek() {
        return head == null ? null : head.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E e) {
            this.data = e;
        }
    }
}
