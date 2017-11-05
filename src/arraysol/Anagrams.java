package arraysol;

import java.util.Arrays;

public class Anagrams {


    public static boolean isAnagram(String word1, String word2) {

        if (word1 == null && word2 == null) {
            return true;
        } else if (word1.length() <= 1 && word1.length() <= 1) {
            return true;
        } else if ((word1 == null && word2 != null) || (word1 != null && word2 == null) || (word1.length() != word2.length())) {
            return false;
        } else {
            Map<Character, Integer> map1 = new HashMap<>();

            char[] chars1 = word1.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                Character ch = chars1[i];
                if (map1.containsKey(ch)) {
                    int value = map1.get(ch);
                    map1.put(ch, value + 1);
                } else {
                    map1.put(ch, 1);
                }
            }
            System.out.println("map " + map1);
            char[] char2 = word2.toCharArray();

            for (int i = 0; i < char2.length; i++) {
                Character ch = char2[i];
                if (map1.containsKey(ch)) {
                    int value = map1.get(ch);
                    if (value > 1) {
                        map1.put(ch, value - 1);
                    } else {
                        map1.remove(ch);
                    }
                } else {
                    return false;
                }
            }

            return map1.size() == 0;
        }

    }

    public static boolean isAnagramBetter(String str, String str2) {
        char[] ch2 = str2.toCharArray();
        char[] ch1 = str.toCharArray();
        Arrays.sort(ch2);
        Arrays.sort(ch1);
        return Arrays.equals(ch1, ch2);

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("isAnagram" + isAnagram("bala", "alab"));
        System.out.println("isAnagram" + isAnagram("bala", ""));
        System.out.println("isAnagram" + isAnagram("bala", null));
        System.out.println("isAnagram" + isAnagram("bala", "abala123"));
        System.out.println("isAnagram" + isAnagram("olleh", "hello"));
        System.out.println("isAnagramBetter " + isAnagramBetter("bala", "alab"));

    }

}
