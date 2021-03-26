import java.util.*;
import java.util.stream.Collectors;

/*
It's time for a holiday! The company's employees decided to go to the corporate party by taxi, but decided to call as few cars as possible to make it cheaper. It was considered that a person of any weight can sit in the front seat, and up to 210 kg in total or three people in the rear. What is the minimum number of cars you need to call in order to take everyone to a corporate party?
Input:

weight - numbers array - the weights of each employee in the company
Output:

integer - the number of cars
Example:

weight = [89, 46, 134, 78, 79, 67, 63, 81]
getResult (weight) → 2
first car: 134 + 79, 67, 63
second car: 89 + 78, 81, 46
 */
public class A011_PartyByTaxi {



    //TODO imcomplete Time:0.34 sec Tests: Passed: 6/8 Failed: 2/8
    public static int getResult(List<Integer> weightTmp) {
        // Write your code here...

        List<Integer> weight = new ArrayList<>();
        weight.addAll(weightTmp);

//        89, 46, 134, 78, 79, 67, 63, 81
//        134, 89, 46, 78, 79, 67, 63, 81
        Collections.sort(weight, Collections.reverseOrder());
//        System.out.println(weight);

        int startWith = Math.floorDiv(weight.size(), 4);

        if (weight.size() % 4 > 0){
            startWith++;
        }
        List<Integer> tryTaxi = new ArrayList<>();
        List<Integer> currentTaxi = new ArrayList<>();

        List<Integer> frontSeat = weight.stream().limit(startWith).collect(Collectors.toList());

        while (true){
            tryTaxi.clear();
            if (!getCar(weight, startWith, tryTaxi, currentTaxi)){
                if (weight.size() < startWith){
                    startWith++;
                } else {
                    break;
                }
            }

        }


        return  startWith;

    }

    private static boolean getCar(List<Integer> weight, int startWith, List<Integer> tryTaxi, List<Integer> currentTaxi) {
        int trying = 0;
        searchCar:
        for (int i = startWith; i < weight.size(); i++) {
            tryTaxi.add(weight.get(i));

            for (int i1 = i + 1; i1
                    < weight.size(); i1++) {
                tryTaxi.add(weight.get(i1));
//                if (tryCar(tryTaxi, currentTaxi, weight))
//                    return true;

                for (int i2 = i1 + 1; i2 < weight.size(); i2++) {

                    tryTaxi.add(weight.get(i2));
                    if (tryCar(tryTaxi, currentTaxi, weight))
                        break searchCar;

                }
                tryTaxi.remove(tryTaxi.size() - 1);

            }
            tryTaxi.remove(tryTaxi.size() - 1);
        }
        weight.removeAll(currentTaxi);
        if (tryTaxi.isEmpty()){
            for (int i = weight.size() - 1; i >= startWith; i--) {
                weight.remove(i);
            }
        }
        if(weight.size() <= startWith){
            return false;

        }
        return true;
    }

    private static boolean tryCar(List<Integer> tryTaxi, List<Integer> currentTaxi, List<Integer> weight) {
        int sum = tryTaxi.stream().mapToInt(Integer::valueOf).sum();
//        System.out.println("tryTaxi: " + tryTaxi);
//        System.out.println(sum);
//        System.out.println(currentTaxi.stream().mapToInt(Integer::valueOf).sum());
        if (sum > currentTaxi.stream().mapToInt(Integer::valueOf).sum() &&
            sum < 211){


            currentTaxi.clear();
            currentTaxi.addAll(tryTaxi);
            tryTaxi.remove(tryTaxi.size() - 1);
            return true;
        } else {
            tryTaxi.remove(tryTaxi.size() - 1);
            return false;
        }

    }

    public static void runCode() {
        System.out.println(getResult(Arrays.asList(89, 46, 134, 78, 79, 67, 63, 81, 66)));
        System.out.println(getResult(Arrays.asList(89, 46, 134, 78, 79, 67, 63, 81, 66, 90)));
        System.out.println(getResult(Arrays.asList(89, 46, 134, 78, 79, 67, 63, 81, 150)));
        System.out.println(getResult(Arrays.asList(89, 46, 134, 78, 79, 67, 63, 81)));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
