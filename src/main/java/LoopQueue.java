/**
 * 自定义循环队列
 *
 * @author chy
 * @date 2020-07-16 15:30
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail, size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public void enqueue(E e) {
        if ((this.tail + 1) % this.data.length == this.front)
            this.resize(this.getCapaticy() * 2);

        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;

        if (this.size == this.getCapaticy() / 4 && this.getCapaticy() / 2 != 0)
            this.resize(this.getCapaticy() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        return this.data[this.front];
    }

    private int getCapaticy() {
        return this.data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[(front + i) % this.data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", this.size, this.getCapaticy()));
        res.append("front [");
        for (int i = this.front; i != this.tail; i = (i + 1) % this.data.length) {
            res.append(this.data[i]);
            if ((i + 1) % this.data.length != this.tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
