/**
 * 自定义数组测试
 *
 * @author chy
 * @date 2020-05-08 11:44
 */
public class ArrayTest {

    public static void main(String[] args) {
        Array<Integer> arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        int index = arr.find(5);
        System.out.println(index);

        for (int i = 0; i < 3; i++) {
            arr.addLast(i % 2);
        }
        System.out.println(arr);

        int[] indexArr = arr.findAll(0);
        for (int i = 0; i < indexArr.length; i++) {
            System.out.print(indexArr[i] + " ");
        }
    }

}
