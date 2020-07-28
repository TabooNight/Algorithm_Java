/**
 * 链表测试
 *
 * @author chy
 * @date 2020-07-17 17:29
 */
public class ListedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

        list.add(2, 666);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
}

