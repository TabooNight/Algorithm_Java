/**
 * 使用链表实现队列
 *
 * @author chy
 * @date 2020-07-28 15:29
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (this.tail == null) {
            this.tail = new Node(e);
            this.head = this.tail;
        } else {
            this.tail.next = new Node(e);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node retNode = this.head;
        this.head = this.head.next;
        retNode.next = null;
        if (this.head == null)
            this.tail = null;
        this.size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (this.isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return this.head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
