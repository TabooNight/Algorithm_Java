/**
 * 链表
 *
 * @author chy
 * @date 2020-07-17 11:15
 */
public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return this.size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 在链表的index(0-based)位置添加新元素e
    // 在链表中不是一个常用的操作，练习用
    public void add(int index, E e) {
        if (index <0 || index > this.size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        this.size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        this.add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        this.add(this.size, e);
    }

    // 获得链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public E get(int index) {
        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return this.get(0);
    }

    // 获取链表的最后一个元素
    public E getLast() {
        return this.get(this.size - 1);
    }

    // 修改链表的第index（0-based）个位置的元素为e
    // 在链表中不是一个常用的操作，练习用
    public void set(int index, E e) {
        if (index < 0 || index > this.size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否存在元素e
    public boolean contains(E e) {
        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index（0-based）位置的元素，返回删除的元素
    // 从链表中删除元素不是一个常用操作，练习用
    public E remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        this.size--;

        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return this.remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return this.remove(this.size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("LinkedList: ");
        Node cur = this.dummyHead.next;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
