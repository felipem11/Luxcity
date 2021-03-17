import java.util.Arrays;

public class A001_FourLetters {

    /**
     * Implement method fourLetters
     */
    public static int fourLetters(String names) {
        // Write your code here...
        return (int) Arrays.stream(names.split(" "))
                .filter(n -> n.length() == 4)
                .count();

    }

    public static void runCode() {
        System.out.println(fourLetters("Tror Gvigris Deriana Nori"));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
