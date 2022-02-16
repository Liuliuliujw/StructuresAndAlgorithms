package list;

import java.util.Iterator;

/**
 * 表的简单数组实现（顺序表）
 *
 * @author llliujw
 */
public class ArrayList implements List {

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

    private static final int DEFAULT_CAPACITY = 10;

    ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    ArrayList(int capacity) {
        size = 0;
        this.capacity = capacity;
        values = new Integer[capacity];
    }

    @Override
    public void insert(int pos, Integer value) {
        if (size + 1 - pos < 0 || pos < 0) return;
        if (size == capacity) grow();
        System.arraycopy(values, pos, values, pos + 1, size - pos);
        values[pos] = value;
        size++;
    }

    @Override
    public void append(Integer value) {
        if (size == capacity) grow();
        values[size++] = value;
    }

    @Override
    public Integer get(int pos) {
        return values[pos];
    }

    @Override
    public void modify(int pos, Integer value) {
        if (size + 1 - pos < 0 || pos < 0) return;
        values[pos] = value;
    }

    @Override
    public void remove(int pos) {
        if (size + 1 - pos < 0 || pos < 0) return;
        System.arraycopy(values, pos + 1, values, pos, size - 1 - pos);
        size--;
    }

    @Override
    public void removeLast() {
        size--;
    }

    @Override
    public int size() {
        return size;
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

    /**
     * 获取迭代器
     *
     * @return 迭代器
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iter(values, size);
    }

    /**
     * 迭代器
     */
    static class Iter implements Iterator<Integer> {

        Integer[] target;

        int temp;

        int size;

        Iter(Integer[] target, int size) {
            this.target = target;
            this.size = size;
            temp = 0;
        }

        @Override
        public boolean hasNext() {
            return temp < size;
        }

        @Override
        public Integer next() {
            return target[temp++];
        }
    }
}
