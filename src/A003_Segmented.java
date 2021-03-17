import java.util.Arrays;
import java.util.List;

/**
Given a non-empty string s and an array words containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
In the input:

s - string
words - array of strings
 At the output: boolean

 Example:
1.

s = "onetwoone"
words = ["one", "two"]
getResult( s, words ) --> true
"onetwoone" can be segmented as "one two one".
Note that you are allowed to reuse a dictionary word.
2.

s = "onetwone"
words = ["one", "two"]
getResult( s, words ) --> false
 **/
public class A003_Segmented {

    public static boolean getResult(String s, List<String> words) {
        for (String word : words) {
            s = s.replace(word, "");
        }
        return s.isEmpty() ? true: false;
        // Write your code here...
    }

    public static void runCode() {
        System.out.println(getResult("onetwoone", Arrays.asList("one", "two")));

        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
