package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

/**
 * 表达式树
 *
 * @author llliujw
 */
public class ExpressionTree {

    /**
     * 存储树的根节点
     */
    private final BinaryNode<String> root;

    /**
     * 依照后缀表达式构造表达式树
     *
     * @param suffixExpression 后缀表达式
     */
    ExpressionTree(String[] suffixExpression) {
        Deque<BinaryNode<String>> stack = new ArrayDeque<>();
        for (String item : suffixExpression) {
            if (isNumeric(item)) {
                stack.push(new BinaryNode<>(item, null, null));
            } else { //弹栈并构造新节点，注意：这里先弹栈的是右子树
                BinaryNode<String> right = stack.pop();
                BinaryNode<String> left = stack.pop();
                stack.push(new BinaryNode<>(item, left, right));
            }
        }
        this.root = stack.pop();
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return 是否为数字
     */
    private boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) return false;
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * 先序遍历表达式树，获得前缀表达式
     *
     * @return 前缀表达式
     */
    public String preorderTraversal() {
        return listToString(BinaryTreeUtil::preorderTraversal);
    }

    /**
     * 中序遍历表达式树，获得中缀表达式
     * 值得注意的一点是仅靠二叉树中序遍历得到表达式不完整(不包含括号)
     *
     * @return 中缀表达式
     */
    public String inorderTraversal() {
        return listToString(BinaryTreeUtil::inorderTraversal);
    }

    /**
     * 后序遍历表达式树，获得后缀表达式
     *
     * @return 后缀表达式
     */
    public String postorderTraversal() {
        return listToString(BinaryTreeUtil::postorderTraversal);
    }

    /**
     * 将方法返回的List转化为String
     *
     * @param ftn 返回List方法
     * @return 转化后的字符串
     */
    private String listToString(Function<BinaryNode<String>, List<String>> ftn) {
        List<String> list = ftn.apply(root);
        StringJoiner res = new StringJoiner(",", "[", "]");
        if (list != null) list.forEach(res::add);
        else return null;
        return res.toString();
    }
}
