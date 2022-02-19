package queue;

/**
 * 利用链式结构实现变长队列
 *
 * @author llliujw
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> front;
    private Node<E> rear;

    LinkedQueue() {
        front = rear = null;
    }

    @Override
    public boolean enqueue(E e) {
        Node<E> node = new Node<>(e);
        if (rear == null) { //若队空，使队头队尾均指向新节点的引用
            front = rear = node;
        } else {    //若队非空，使队尾的下一节点指向新节点 并 移动队尾引用指向
            rear.next = node;
            rear = node;
        }
        return true;
    }

    @Override
    public E dequeue() {
        //队空返回null
        if (front == null) return null;
        //出队
        E e = front.data;
        if (front.next == null) front = rear = null; //若队空 使 队头队尾均为null
        else front = front.next; //移动队头引用指向
        return e;
    }

    @Override
    public E peek() {
        return front == null ? null : front.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E e) {
            this.data = e;
        }
    }
}
