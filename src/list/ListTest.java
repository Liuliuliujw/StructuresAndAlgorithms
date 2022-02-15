package list;

import java.util.Random;

/**
 * @author llliujw
 */
public class ListTest {

    private static final int[] mock = new int[5];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            mock[i] = random.nextInt(10);
            System.out.print(mock[i]);
        }
        System.out.println();
        test(new ArrayList(1));
    }

    private static void test(List myList){
        System.out.println("==================================");
        myList.append(mock[0]);
        myList.append(mock[1]);
        myList.insert(1,mock[2]);
        myList.insert(1,mock[3]);
        System.out.println(myList.get(1));
        myList.modify(1,mock[4]);
        myList.forEach(System.out::print);
        System.out.println(",size:"+myList.size());
        myList.remove(2);
        myList.forEach(System.out::print);
        System.out.println(",size:"+myList.size());
        myList.removeLast();
        myList.forEach(System.out::print);
        System.out.println(",size:"+myList.size());
    }
}
