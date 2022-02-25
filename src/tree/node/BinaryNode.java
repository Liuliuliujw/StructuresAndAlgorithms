package tree.node;

/**
 * 二叉树节点
 * 这应该是静态内部类，但为了方便 单拎出来 且属性公开
 *
 * @author llliujw
 */
public class BinaryNode<E> {
    public E element;
    public BinaryNode<E> left;
    public BinaryNode<E> right;

    public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}