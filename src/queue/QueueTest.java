package queue;

import java.util.*;

/**
 * 测试该包中Queue的各种实现
 *
 * @author llliujw
 */
public class QueueTest {

    public static void main(String[] args) {
        /*
        示例1 : [[1,1],2,[1,1]]
         */
        //初始化数据
        ArrayList<NestedInteger> list1 = new ArrayList<>();
        list1.add(new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))));
        list1.add(new NestedInteger(2));
        list1.add(new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))));
        //测试
        NestedIterator iterator1 = new NestedIterator(list1, new LinkedQueue<>());
        //输出
        StringJoiner res1 = new StringJoiner(",", "[", "]");
        while (iterator1.hasNext()) {
            res1.add(String.valueOf(iterator1.next()));
        }
        System.out.println(res1);

        /*
        示例2 : [1,[4,[6]]]
         */
        //初始化数据
        ArrayList<NestedInteger> list2 = new ArrayList<>();
        list2.add(new NestedInteger(1));
        list2.add(new NestedInteger(Arrays.asList(new NestedInteger(4),
                new NestedInteger(List.of(new NestedInteger(6))))));
        //测试
        NestedIterator iterator2 = new NestedIterator(list2, new CircleQueue<>(5));
        //输出
        StringJoiner res2 = new StringJoiner(",", "[", "]");
        while (iterator2.hasNext()) {
            res2.add(String.valueOf(iterator2.next()));
        }
        System.out.println(res2);

    }

    /**
     * 扁平化嵌套列表迭代器
     * leetcode 341
     * 其中构造方法的queue是为了测试自定义的队列实现类添加的，其他均和题目一样
     */
    private static class NestedIterator implements Iterator<Integer> {

        private final Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList, Queue<Integer> queue) {
            this.queue = queue;
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            return queue.dequeue();
        }

        @Override
        public boolean hasNext() {
            return queue.peek() != null;
        }

        private void dfs(List<NestedInteger> nestedList) {
            nestedList.forEach(item -> {
                if (item.isInteger()) queue.enqueue(item.getInteger());
                else dfs(item.getList());
            });
        }
    }

    /**
     * 该类简但的实现了上面题目中给出的接口
     */
    private static class NestedInteger {
        Object data;
        boolean isInteger;

        NestedInteger(Integer data) {
            this.data = data;
            isInteger = true;
        }

        NestedInteger(List<NestedInteger> data) {
            this.data = data;
            isInteger = false;
        }

        boolean isInteger() {
            return isInteger;
        }

        int getInteger() {
            return (Integer) data;
        }

        public List<NestedInteger> getList() {
            return (List<NestedInteger>) data;
        }
    }

}
