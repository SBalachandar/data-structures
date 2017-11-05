package strings;

public class StringTesting {

    public static void iterate(String str) {

        if (str == null || str.length() == 0)
            return;

        char[] chrs = str.toCharArray();
        int i = 0;

        while (i < chrs.length) {
            char c = chrs[i];
            System.out.print(" " + c);
            i++;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        iterate("Abhinav");

    }

}
