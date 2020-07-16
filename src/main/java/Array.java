/**
 * 动态数组
 *
 * @author chy
 * @date 2020-05-08 11:25
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // 无参构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return this.size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return this.data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 向数组末尾添加一个新元素e
    public void addLast(E e) {
        add(this.size, e);
    }

    // 在数组最开始添加一个新元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (this.size == this.data.length) {
            resize(this.data.length * 2);
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = e;
        this.size++;
    }

    // 获取第index个位置的元素
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return this.data[index];
    }

    // 获取最后一个位置的元素
    public E getLast() {
        return get(this.size - 1);
    }

    // 获取第一个位置的元素
    public E getFirst() {
        return get(0);
    }

    // 修改第index个位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        this.data[index] = e;
    }

    // 查找数组中是否含有元素e
    public boolean contains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中第一个元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 查找数组中所有元素e所在的索引，如果不存在元素e，则返回null
    public int[] findAll(int e) {
        StringBuilder indexBuilder = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e)) {
                if (indexBuilder.length() > 0) {
                    indexBuilder.append(",");
                }
                indexBuilder.append(i);
            }
        }

        if (indexBuilder.length() > 0) {
            String[] indexArr = indexBuilder.toString().split(",");
            int[] ids = new int[indexArr.length];
            for (int i = 0; i < indexArr.length; i++) {
                ids[i] = Integer.parseInt(indexArr[i]);
            }
            return ids;
        }
        return null;
    }

    // 从数组中删除index位置的元素，并返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = this.data[index];
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
        this.data[this.size] = null; // 释放内存引用，否则会导致垃圾回收无法回收该对象

        if (this.size == this.data.length / 4 && this.data.length / 2 != 0) {
            resize(this.data.length / 2);
        }

        return ret;
    }

    // 从数组中删除第一个元素，并返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，并返回删除的元素
    public E removeLast() {
        return remove(this.size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < this.size; i++) {
            res.append(this.data[i]);
            if (i != this.size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        if (this.size >= 0) {
            System.arraycopy(this.data, 0, newData, 0, this.size);
        }
        this.data = newData;
    }
}