/**
 * 自定义栈接口
 *
 * @author chy
 * @date 2020-06-09 10:36
 */
public interface Stack<E> {

    // 获取栈大小
    int getSize();

    // 栈是否为空
    boolean isEmpty();

    // 向栈中添加元素
    void push(E e);

    // 取出栈顶元素
    E pop();

    // 查看栈顶元素，但是元素不需要进行出栈操作
    E peek();

}
