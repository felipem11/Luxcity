import java.util.Arrays;
import java.util.*;
/*
You are installing a billboard and want it to have the largest height.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.

You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.

In the input:

rods - array of integers
 At the output: integer

 Example:
1.

rods = [2,8,5,1]
getHeight( rods ) --> 8
2.

rods = [3,7]
getHeight( rods ) --> 0
 */
public class A008_Billboard {

    private static Integer[][] memo;
    /**
     * Implement method fourLetters
     */
    private static int ninf = Integer.MIN_VALUE / 3;

    public static int getHeight(List<Integer> rods) {
        // Write your code here...
        int length = rods.size();
        memo = new Integer[length][10001];
        int[] primitive = rods.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return (int) dp(primitive, 0, 5000);
    }

    private static int dp(int[] rods, int i, int s) {
        if (i == rods.length) {
            return s == 5000 ? 0 : ninf;
        } else if (memo[i][s] != null) {
            return memo[i][s];
        } else {
            int ans = dp(rods, i+1, s);
            ans = Math.max(ans, dp(rods, i+1, s-rods[i]));
            ans = Math.max(ans, rods[i] + dp(rods, i+1, s+rods[i]));
            memo[i][s] = ans;
            return ans;
        }
    }

    public static void runCode() {
        System.out.println(getHeight(Arrays.asList(2,8,5,1,4)));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
