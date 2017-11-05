package myds;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<T> implements Iterable<T> {

    private Node head;
    private int size;

    public Stack() {
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Stack<String> s1 = new Stack<String>();
        System.out.println(" pushing 1 in stack 1");

        s1.push("1");
        System.out.println(" pushing 1 in stack 2");

        s1.push("a2");
        System.out.println(" pushing 1 in stack 3");

        s1.push("dsf3");
        System.out.println(" pushing 1 in stack 4");

        s1.push("df4");
        System.out.println(" size" + s1.getSize());

        Iterator<String> it = s1.iterator();
        while (it.hasNext()) {
            System.out.print(" next : " + it.next());
        }

        //System.out.println("s " + s1.peek());
        System.out.println("\ns " + s1.pop());
        System.out.println("s  " + s1.pop());
        System.out.println("s " + s1.pop());
        //System.out.println("s " + s1.peek());
        System.out.println("s " + s1.pop());
        System.out.println("s " + s1.pop());
        System.out.println("s " + s1.pop());

    }

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        } else {
            T data = head.data;
            return data;
        }
    }

    public void push(T data) {
        Node node = new Node(data);

        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public T pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        } else {
            Node node = head;
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
            size--;
            return node.data;
        }
    }

    public int getSize() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private class ListIterator implements Iterator<T> {

        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                T data = current.data;
                current = current.next;
                return data;
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
