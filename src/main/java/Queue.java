/**
 * 自定义队列接口
 *
 * @author chy
 * @date 2020-07-16 15:10
 */
public interface Queue<E> {

    // 获取队列大小
    int getSize();

    // 队列是否为空
    boolean isEmpty();

    // 入队
    void enqueue(E e);

    // 出队
    E dequeue();

    // 获取队首元素，但不进行出队操作
    E getFront();

}
