import java.util.Arrays;

/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
In the input:

v1 - string
v2 - string
 At the output: number (1 or -1 or 0)

 Example:
1.

v1 = "1.1"
v2 = "1.002"
getResult( v1, v2 ) --> -1
2.

v1 = "2.001"
v2 = "2.1.0"
getResult( v1, v2 ) --> 0
 */
public class A007_CompareVersion {

    /**
     * Implement method fourLetters
     */
    public static int getResult(String v1, String v2) {
        // Write your code here...
        String[] v1Spplited = v1.split("\\.");
        String[] v2Spplited = v2.split("\\.");

        int longest = 0;
        if (v1Spplited.length > v2Spplited.length)
            longest = v1Spplited.length;
        else
            longest = v2Spplited.length;

        for (int i = 0; i <= longest -1; i++) {
            int v1Int = 0;
            if (v1Spplited.length >= i +1 )
                v1Int = Integer.parseInt(v1Spplited[i]);

            int v2Int = 0;
            if (v2Spplited.length >= i +1 )
                v2Int = Integer.parseInt(v2Spplited[i]);

            if(v1Int < v2Int) return -1;
            if(v1Int > v2Int) return 1;

        }
        return 0;

    }

    public static void runCode() {
        System.out.println(getResult("2.0001", "2.1.0"));
        System.out.println(getResult("1.1", "1.002"));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
