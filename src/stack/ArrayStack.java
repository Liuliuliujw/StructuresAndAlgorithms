package stack;

/**
 * 栈的简单数组实现
 *
 * @author llliujw
 */
public class ArrayStack implements Stack {

    /**
     * 存储元素
     */
    private Integer[] values;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 5;

    ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    ArrayStack(int capacity) {
        this.capacity = capacity;
        values = new Integer[capacity];
    }

    @Override
    public void push(Integer value) {
        if (size == capacity) grow();
        values[size++] = value;
    }


    @Override
    public Integer pop() {
        return values[size--];
    }

    @Override
    public Integer top() {
        return values[size];
    }

    /**
     * 扩容
     */
    private void grow() {
        Integer[] temp = values;
        values = new Integer[capacity << 1];
        System.arraycopy(temp, 0, values, 0, capacity);
        capacity = capacity << 1;
    }

}
