package myds;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackArray implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public StackArray(int capacity) {
        a = new String[capacity];
        N = 0;
    }

    public static void main(String[] args) {

        StackArray st = new StackArray(10);
        st.peek();
        for (int i = 0; i < 10; i++) {
            st.push("Bala" + i);
        }
        Iterator<String> it = st.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            //it.remove();
        }


    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public String peek() {
        return a[N - 1];
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
