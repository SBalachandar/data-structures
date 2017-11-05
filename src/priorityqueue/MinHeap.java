package priorityqueue;

public class MinHeap {

    private int size;
    private int[] mH;
    private int position;

    public MinHeap(int size) {
        this.size = size;
        this.position = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void createHeap(int[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                insert(i);
            }
        }

    }

    public void insert(int i) {

        if (position == 0) {
            mH[position + 1] = i;
            position = 2;
        } else {
            mH[position++] = i;
            percUp();

        }

    }

    public int deleteMin() {

        int min = mH[1];
        mH[1] = mH[position - 1];
        mH[position - 1] = 0;
        position--;
        percDown(1);
        return min;

    }

    public void percUp() {
        int pos = position - 1;
        while (pos > 0 && mH[pos / 2] > mH[pos]) {
            int y = mH[pos];
            mH[pos] = mH[pos / 2];
            mH[pos / 2] = y;
            pos = pos / 2;
        }

    }

    public void percDown(int k) {
        int a = mH[k];
        int smallest = k;
        if (2 * k < position && mH[smallest] > mH[2 * k]) {
            smallest = 2 * k;
        }
        if (2 * k + 1 < position && mH[smallest] > mH[2 * k + 1]) {
            smallest = 2 * k + 1;
        }
        if (smallest != k) {
            swap(k, smallest);
            percDown(smallest);
        }

    }

    public void swap(int a, int b) {
        // System.out.println("swappinh" + mH[a] + " and " + mH[b]);
        int temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }

    public void display() {
        for (int i = 1; i < mH.length; i++) {
            System.out.print(" " + mH[i]);
        }
        System.out.println("");
    }

}
