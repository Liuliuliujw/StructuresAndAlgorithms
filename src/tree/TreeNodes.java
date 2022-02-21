package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 一般树的节点实现
 *
 * @author llliujw
 */
public class TreeNodes {

    /**
     * 我认为存储树节点的方式
     *
     * @param <E> 元素类型
     */
    private static class TreeNode1<E> {
        //元素
        E element;
        //所有子节点
        List<E> child = new LinkedList<>();
    }

    /**
     * 书上给出的存储方法--第一儿子/下一兄弟表示法
     *
     * @param <E> 元素类型
     */
    private static class TreeNode2<E> {
        //元素
        E element;
        //第一个子节点
        TreeNode2<E> firstChild;
        //下一兄弟节点
        TreeNode2<E> nextSibling;
    }
}
