package list;

/**
 * 定义一个表(列表)需要实现的基本方法
 * 继承Iterable的原因是 Java API中表示集合的Collection接口继承了Iterable，他可以提供迭代器和 遍历的forEach方法
 *
 * @author llliujw
 */
public interface List extends Iterable<Integer> {

    /**
     * 在指定位置添加数据
     *
     * @param pos   位置下标
     * @param value 值
     */
    void insert(int pos, Integer value);

    /**
     * 在末尾添加数据
     *
     * @param value 值
     */
    void append(Integer value);

    /**
     * 获取给定位置元素的值
     *
     * @param pos 位置下标
     * @return 值
     */
    Integer get(int pos);

    /**
     * 修改给定位置元素
     *
     * @param pos   位置下标
     * @param value 值
     */
    void modify(int pos, Integer value);

    /**
     * 移除给定位置元素
     *
     * @param pos 位置下标
     */
    void remove(int pos);

    /**
     * 移除最后一个元素
     */
    void removeLast();

    /**
     * 获取表中数据的大小
     *
     * @return 表中数据的大小
     */
    int size();
}
