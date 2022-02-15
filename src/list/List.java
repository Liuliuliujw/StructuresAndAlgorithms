package list;

/**
 * 定义一个表(列表)需要实现的基本方法
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
