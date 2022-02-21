package tree;

import stack.StackTest;

/**
 * 测试该包中各种用途树的实现
 *
 * @author llliujw
 */
public class TreeTest {

    public static void main(String[] args) {
        testExpressionTree();
    }

    private static void testExpressionTree(){
        System.out.println("===============testExpressionTree===============");
        //示例1: (1+2)*(3*(4+5))
        String[] suffix1 = new String[]{"1","2","+","3","4","5","+","*","*"};
        ExpressionTree expressionTree1 = new ExpressionTree(suffix1);
        System.out.println(expressionTree1.preorderTraversal());
        System.out.println(expressionTree1.inorderTraversal());
        System.out.println(expressionTree1.postorderTraversal());
        //示例1: (2+1*1-1)*3+5
        String[] suffix2 = new String[]{"2","1","1","*","+","1","-","3","*","5","+"};
        ExpressionTree expressionTree2 = new ExpressionTree(suffix2);
        System.out.println(expressionTree2.preorderTraversal());
        System.out.println(expressionTree2.inorderTraversal());
        System.out.println(expressionTree2.postorderTraversal());
    }
}
