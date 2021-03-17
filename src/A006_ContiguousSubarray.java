import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A006_ContiguousSubarray {

    /**
     * Implement method fourLetters
     */
    public static int getResult(List<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size() -1) - nums.get(0);
        // Write your code here...
//        return 0;

    }

    public static void runCode() {
        System.out.println(getResult(Arrays.asList(5,3,-6,9)));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
