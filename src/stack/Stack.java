package stack;

/**
 * 定义一个栈需要实现的基本方法
 *
 * @author llliujw
 */
public interface Stack {

    /**
     * 压栈
     *
     * @param value 值
     */
    void push(Integer value);

    /**
     * 出栈
     *
     * @return 栈顶的值
     */
    Integer pop();

    /**
     * 查看栈顶元素
     *
     * @return 栈顶的值
     */
    Integer top();
}
