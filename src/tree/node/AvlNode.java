package tree.node;

/**
 * @author llliujw
 */
public class AvlNode<E> extends BinaryNode<E> {
    public int height;

    public AvlNode(E element) {
        this(element, null, null);
    }

    public AvlNode(E element, AvlNode<E> lt, AvlNode<E> rt) {
        super(element, lt, rt);
        height = 0;
    }
}
