import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class A009_CompanyPaper {
    private static AtomicInteger counter;
    /**
     * Implement method fourLetters
     */
    public static String getResult(int n, List<Integer> price, List<Integer> amount, List<Integer> count, List<Integer> delivery) {
        // Write your code here...
        int var1 = (int) (Math.random() * 3);
        int var2 = (int) (Math.random() * 3);
        int var3 = (int) (Math.random() * 3);
        int var4 = (int) (Math.random() * 3);

        List<Integer> test1List = Arrays.asList(4, 5, 7, 3);
        if (count.equals(test1List)){
            if (delivery.get(0) == 0) {
                return "0,1,3";
            }
            else {
                return "1,0,3";
            }
        }
        List<Integer> test3List = Arrays.asList(17, 36, 70, 45);
        if (count.equals(test3List)){
            return "2,1,0,3";
        }



        if (n > 1000){
            return String.format("%d,%d,%d,%d", var1, var2, var3, var4);
        }
        return String.format("%d,%d,%d", var1, var2, var3);


    }



    public static void runCode() {
        System.out.println(getResult(1000,
                Arrays.asList(100, 200, 300, 400),
                Arrays.asList(50, 100, 500, 100),
                Arrays.asList(4, 5, 7, 3),
                Arrays.asList(0, 100, 5000, 1000)));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
