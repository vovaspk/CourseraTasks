import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private final Node first;
    private int size;
    private final Node last;

    public Deque() {
        first = new Node();
        last = new Node();
        first.next = last;
        last.pre = first;
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            Node temp = new Node();
            Node afterFirst = first.next;
            temp.item = item;
            temp.next = afterFirst;
            afterFirst.pre = temp;
            first.next = temp;
            temp.pre = first;

            size++;
        }
    }


    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        } else {
            Node temp = new Node();
            Node preLast = last.pre;
            temp.item = item;
            temp.pre = preLast;
            preLast.next = temp;
            last.pre = temp;
            temp.next = last;

            size++;
        }
    }


    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Node afterFirst = first.next;
            Item item = afterFirst.item;
            first.next = afterFirst.next;
            afterFirst.next.pre = first;

            size--;
            return item;
        }
    }


    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Node preLast = last.pre;
            Item item = preLast.item;
            last.pre = preLast.pre;
            preLast.pre.next = last;

            size--;
            return item;
        }
    }


    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = first.next;

        @Override
        public boolean hasNext() {
            return current.item != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class Node
    {
        Item item;
        Node next;
        Node pre;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.removeLast();
        deque.isEmpty();
        deque.isEmpty();
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);
        deque.removeLast();
    }
}
