package recursive;

public class StringReverse {

    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        String result = reverse(str.substring(1)) + str.charAt(0);
        return result;

    }

    public static String reverse1(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        int low = 0;
        int high = str.length() - 1;

        while (low <= high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low = low + 1;
            high = high - 1;
        }
        return new String(chars);

    }


}
