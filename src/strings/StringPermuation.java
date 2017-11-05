package strings;

public class StringPermuation {

    public static void main(String aaa[]) {
        StringPermuation permuation = new StringPermuation();
        String str = "ABC";
        permuation.permuate(str, 0, str.length() - 1);

    }

    public void permuate(String str, int l, int r) {

        if (l == r) {
            System.out.println(" " + str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permuate(str, l + 1, r);
                str = swap(str, l, i);
            }
        }

    }

    public String swap(String s, int i, int j) {
        char[] chs = s.toCharArray();
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
        return String.valueOf(chs);
    }

}
