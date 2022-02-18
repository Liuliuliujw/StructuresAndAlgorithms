package stack;

import java.util.*;

/**
 * 测试该包中Stack的各种实现
 *
 * @author llliujw
 */
public class StackTest {

    public static void main(String[] args) {
        //中缀1: (2+1*1-1)*3+5
        String[] infix1 = new String[]{"(", "2", "+", "1", "*", "1", "-", "1", ")", "*", "3", "+", "5"};
        //中缀2: 4+(13/5)*(2+3)
        String[] infix2 = new String[]{"4", "+", "(", "13", "/", "5", ")", "*", "(", "2", "+", "3", ")"};

        //测试1
        String[] suffix1 = infix2Suffix(infix1);
        System.out.println(Arrays.toString(suffix1));
        System.out.println(evalRPN(new LinkedStack(), suffix1));

        //测试2
        String[] suffix2 = infix2Suffix(infix2);
        System.out.println(Arrays.toString(suffix2));
        System.out.println(evalRPN(new LinkedStack(), suffix2));

    }

    /**
     * 计算逆波兰表达式（后缀表达式）
     * leetcode 150
     *
     * @param rpn 逆波兰表达式
     * @return 结果
     */
    static int evalRPN(Stack myStack, String[] rpn) {
        for (String item : rpn) {
            if ("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)) {
                int p1 = myStack.pop();
                int p2 = myStack.pop();
                switch (item) {
                    case "+":
                        myStack.push(p2 + p1);
                        break;
                    case "-":
                        myStack.push(p2 - p1);
                        break;
                    case "*":
                        myStack.push(p2 * p1);
                        break;
                    default:
                        myStack.push(p2 / p1);
                        break;
                }
            } else {
                myStack.push(Integer.valueOf(item));

            }
        }
        return myStack.pop();
    }

    /*
    符号权重相关变量
     */
    private static final int LEFT_BRACKET = 0;
    private static final int RIGHT_BRACKET = 1;
    private static final int ADD_OR_SUB = 2;
    private static final int MULTIPLY_OR_DIVISION = 3;
    private static final Map<String, Integer> map = new HashMap<>();

    /**
     * 中缀表示式转后缀表达式
     * 为了简单起见，假设操作数为 0-9 的整数
     * 思路：依次读取表达式，遇到<strong>数字</strong>直接输出；遇到<strong>操作符</strong>先将<strong>栈</strong>中元素弹出，
     * 直到<strong>栈顶元素</strong>是比<strong>读取的操作符</strong>计算优先级低的操作符或左括号，再将<strong>读取的操作符</strong>压入栈中；
     * 遇到<strong>左括号</strong>直接压栈，遇到<strong>右括号</strong>输出操作符直至左括号；
     * 读取到末尾时，输出栈中所有符号。
     *
     * @param infixExpression 中缀表示式
     * @return 后缀表达式
     */
    static String[] infix2Suffix(String[] infixExpression) {
        Deque<String> stack = new ArrayDeque<>();
        //存储输出的后缀表达式结果
        List<String> suffix = new ArrayList<>(infixExpression.length);
        //遍历
        for (String item : infixExpression) {
            switch (item) {
                case "*":
                case "/":
                    outputOper(stack, suffix, MULTIPLY_OR_DIVISION);
                    stack.push(item);
                    break;
                case "+":
                case "-":
                    outputOper(stack, suffix, ADD_OR_SUB);
                    stack.push(item);
                    break;
                case "(":
                    stack.push(item);
                    break;
                case ")":
                    outputOper(stack, suffix, RIGHT_BRACKET);
                    break;
                default: //数字
                    suffix.add(item);
                    break;
            }

        }
        //末尾输出栈中剩余操作符
        while (true) {
            if (stack.peek() != null) suffix.add(stack.pop());
            else break;
        }
        //转换为数组输出
        return suffix.toArray(new String[]{});
    }

    /**
     * infix2Suffix的辅助方法
     * 将源栈中的元素按照规则输出到list中
     *
     * @param srcStack 源栈
     * @param descList 目标集合
     * @param weight   权重
     */
    private static void outputOper(Deque<String> srcStack, List<String> descList, int weight) {
        //初始化符号权重表
        if (map.isEmpty()) {
            map.put("+", ADD_OR_SUB);
            map.put("-", ADD_OR_SUB);
            map.put("*", MULTIPLY_OR_DIVISION);
            map.put("/", MULTIPLY_OR_DIVISION);
            map.put("(", LEFT_BRACKET);
        }
        //弹栈直至出现更低优先级(权重)的符号出现
        while (true) {
            String top = srcStack.peek();
            if (top == null || map.get(top) < weight) break;
            descList.add(srcStack.pop());
        }
        //如果栈顶元素是左括号且正在操作的是右括号，则左括号弹栈
        if (Objects.equals(srcStack.peek(), "(") && weight == RIGHT_BRACKET) srcStack.pop();
    }

}
