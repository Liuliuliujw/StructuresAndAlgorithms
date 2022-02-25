package tree;

import tree.node.BinaryNode;

/**
 * @author llliujw
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) return null;
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) return null;
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        BinaryTreeUtil.inorderTraversal(root).forEach(System.out::print);
        System.out.println();
    }

    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null) return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        else return findMin(t.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null)
            while (t.right != null) t = t.right;
        return t;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) return new BinaryNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        return t;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null) return null;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) //小于搜索左子树
            t.left = remove(x, t.left);
        else if (compareResult > 0) //大于搜索右子树
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {  //有两个子节点时
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else //有一个子节点时
            t = (t.left != null) ? t.left : t.right;
        return t;
    }
}
