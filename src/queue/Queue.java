package queue;

/**
 * 定义一个队(队列)需要实现的基本方法
 *
 * @author llliujw
 */
public interface Queue<E> {

    /**
     * 入队，在队尾添加元素，如果队满则失败
     *
     * @param e 元素
     * @return 是否成功
     */
    boolean enqueue(E e);

    /**
     * 出队，返回并移除队头元素
     *
     * @return 队头元素
     */
    E dequeue();

    /**
     * 查看队头元素但不移除
     *
     * @return 队头元素
     */
    E peek();
}
