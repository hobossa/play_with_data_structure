

public class MyList<E> {
    private static class MyNode<E> {
        E value;
        MyNode<E> next;

        private MyNode(E value, MyNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private MyNode<E> head, tail;

    public MyList() {
        head = tail = new MyNode<E>(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    public void append(E value) {
        if (value == null) {
            throw new NullPointerException("Cannot add null element to the list");
        }
        tail.next = new MyNode<>(value, null);
        tail = tail.next;
        size++;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        MyNode<E> p = head.next;
        while (i-- > 0) {
            p = p.next;
        }
        return p.value;
    }

    public void insert(int i, E value) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        if (i == size) {
            append(value);
        } else {
            MyNode<E> p = head;
            while (i-- > 0) {
                p = p.next;
            }
            MyNode<E> node = new MyNode<E>(value, p.next);
            p.next = node;
            size++;
        }
    }

    public int find(E value) {
        int i = 0;
        MyNode<E> p = head.next;
        while ( p!= tail.next && p.value != value) {
            i++;
            p = p.next;
        }
        if (p != tail.next) {
            return i;
        }
        return -1;
    }

    public void delete(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Out of range");
        }
        MyNode<E> p = head;
        while (i-- > 0) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }
}
