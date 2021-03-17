import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class A002_LongestSubstring {

    /**
     * Implement method fourLetters
     */
    public static int longestSubstring(String names) {
        // Write your code here...
//        "qweqweww"
        String[] spplited = names.split("");

        for (int i = spplited.length; i >= 0; i--) {
            Set<String> letters = new HashSet<>();
//            8, 7 ,6
            for (int j = 0; j < i; j++) {
                for (int k = j; k < spplited.length; k++) {
                    System.out.println(spplited[k]);
                    if (!letters.add(spplited[k]))
                        break;

                }
                if (letters.size() == i) return i;
                letters.clear();
                System.out.println("");
            }
        }

        return 1;


    }

    public static void runCode() {
        System.out.println(longestSubstring("abffcdef"));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
