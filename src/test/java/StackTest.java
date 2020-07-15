/**
 * 自定义栈测试
 *
 * @author chy
 * @date 2020-06-09 17:31
 */
public class StackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}
