package tree;

/**
 * 二叉树节点
 *
 * @author llliujw
 */
public class BinaryNode<E> {
    E element;
    BinaryNode<E> left;
    BinaryNode<E> right;

    BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}