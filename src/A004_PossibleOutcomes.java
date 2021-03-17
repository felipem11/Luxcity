import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a string of numbers and operators expr, return all possible results in ascending order from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

In the input:

expr - string
 At the output: array of integers

 Example:

expr = "2*3-4*5"
getResult( expr ) --> [-34, -14, -10, -10, 10]
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */
public class A004_PossibleOutcomes {

    public static List<Integer> getResult(String expr) {
        // Write your code here...
        List<Integer> currentResults = new ArrayList<Integer>();
        boolean noOp = true;
        for(int i = 0; i < expr.length(); i++){
            // Search for an operator '+', '-', '*'
            if(expr.charAt(i) == '*' || expr.charAt(i) == '+' || expr.charAt(i) == '-'){
                noOp = false;
                // Split the string at operator and find outcomes for left part and right part
                List<Integer> left = getResult(expr.substring(0, i));
                List<Integer> right = getResult(expr.substring(i + 1));
                // Get all outcomes by applying the found operator to all pairs of results from left and right parts
                for(Integer l : left){
                    for(Integer r : right){
                        currentResults.add(evaluate(expr.charAt(i), l, r));
                    }
                }
            }
        }
        // Terminating case: If there was no operator, result is just the number formed by the digits
        if(noOp){
            currentResults.add(Integer.parseInt(expr));
        }
        Collections.sort(currentResults);
        return currentResults;
    }


    static int evaluate(char operator, int lhs, int rhs){
        if(operator == '*'){
            return lhs * rhs;
        }
        else if(operator == '+'){
            return lhs + rhs;
        }
        else{
            return lhs - rhs;
        }
    }

    public static void runCode() {
        System.out.println(getResult("2*3-4*5"));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
