package tree;

import tree.node.BinaryNode;

import java.util.*;

/**
 * @author llliujw
 */
public class BinaryTreeUtil {

    /**
     * 非递归先序遍历二叉树
     *
     * @param root 二叉树的根节点
     * @param <E>      元素类型
     * @return 存储元素的集合
     */
    public static <E> List<E> preorderTraversal(BinaryNode<E> root) {
        if (root == null) return null;
        Deque<BinaryNode<E>> stack = new ArrayDeque<>();
        List<E> resList = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryNode<E> curr = stack.pop();
            resList.add(curr.element);
            //获取根元素的值后，由于栈是先进后出的，所以先压右子树再压左子树。
            if (curr.right != null)stack.push(curr.right);
            if (curr.left != null)stack.push(curr.left);
        }
        return resList;
    }

    /**
     * 非递归中序遍历二叉树
     *
     * @param root 二叉树的根节点
     * @param <E>      元素类型
     * @return 存储元素的集合
     */
    public static <E> List<E> inorderTraversal(BinaryNode<E> root) {
        if (root == null) return null;
        Deque<BinaryNode<E>> stack = new ArrayDeque<>();
        List<E> resList = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) { //这个循环是为了将从root开始的左子节点压栈
                stack.push(root);
                root = root.left;
            }
            BinaryNode<E> curr = stack.pop();
            resList.add(curr.element);
            root = curr.right; //每弹出一个节点都要将右子节点变为cur，因为此时左子树和当前节点已经遍历完了
        }
        return resList;
    }

    /**
     * 非递归后序遍历二叉树
     * 思路：后序遍历按照<左-右-根>的形式遍历节点，我们可以先按照<根-右-左>的顺序遍历然后反转list得到后序所要求的
     *
     * @param root 二叉树的根节点
     * @param <E>      元素类型
     * @return 存储元素的集合
     */
    public static <E> List<E> postorderTraversal(BinaryNode<E> root) {
        if (root == null) return null;
        Deque<BinaryNode<E>> stack = new ArrayDeque<>();
        List<E> resList = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryNode<E> curr = stack.pop();
            resList.add(curr.element);
            if (curr.left != null)stack.push(curr.left);
            if (curr.right != null)stack.push(curr.right);
        }
        Collections.reverse(resList);
        return resList;
    }
}
