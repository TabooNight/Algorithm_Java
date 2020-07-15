/**
 * 自定义栈接口
 *
 * @author chy
 * @date 2020-06-09 10:36
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
