package tree.node;

/**
 * 书上给出的存储方法--第一儿子/下一兄弟表示法
 *
 * @author llliujw
 */
public class TreeNode2<E> {
    //元素
    E element;
    //第一个子节点
    TreeNode2<E> firstChild;
    //下一兄弟节点
    TreeNode2<E> nextSibling;
}
