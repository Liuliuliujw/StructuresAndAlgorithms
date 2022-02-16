package list;

/**
 * 定义一个表(列表)需要实现的基本方法
 * 继承Iterable的原因是 Java API中表示集合的Collection接口继承了Iterable，他可以提供迭代器和 遍历的forEach方法
 *
 * @author llliujw
 */
public interface List extends Iterable<Integer> {

    void insert(int pos, Integer value);

    void append(Integer value);

    Integer get(int pos);

    void modify(int pos, Integer value);

    void remove(int pos);

    void removeLast();

    int size();
}
