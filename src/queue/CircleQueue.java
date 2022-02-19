package queue;

/**
 * 利用数组结构实现循环队列
 *
 * @author llliujw
 */
public class CircleQueue<E> implements Queue<E> {

    /**
     * 由于泛型不能创建数组，所以用Object来存储
     */
    private final Object[] elementData;
    /**
     * 队头下标
     */
    private int front;
    /**
     * 队尾下标
     */
    private int rear;
    /**
     * 队中元素个数
     */
    private int count;

    CircleQueue(int capacity) {
        elementData = new Object[capacity];
        front = rear = 0;
        count = 0;
    }

    @Override
    public boolean enqueue(E e) {
        //队满返回false
        if (count == elementData.length) return false;
        //入队
        elementData[front] = e;
        if (++front == elementData.length) front = 0;//队头下标后移，若下标等于数组长度，置零
        count++;
        return true;
    }

    @Override
    public E dequeue() {
        //队空返回null
        if (count == 0) return null;
        //出队
        E e = (E) elementData[rear];
        if (++rear == elementData.length) rear = 0;//队尾下标后移，若下标等于数组长度，置零
        count--;
        return e;
    }

    @Override
    public E peek() {
        return count == 0 ? null : (E) elementData[rear];
    }
}
