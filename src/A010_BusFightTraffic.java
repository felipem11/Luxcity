import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


public class A010_BusFightTraffic {

    /**
     * Implement method
     */
    public static String  getResult(List<Integer> bus) {
        // Write your code here...
        Map<String, String> traffic = new HashMap();
        Map<String, Integer> trafficSum = new HashMap<>();

//        bus.forEach(b -> traffic.put(b, LocalTime.of(6,0)));
        for (int i = 0; i < bus.size(); i++) {

            LocalTime time = LocalTime.of(6,0);
            while (bus.get(i) > 0 && time.isBefore(LocalTime.of(12,0))){
                time = time.plusMinutes(bus.get(i));
                String timeString = time.toString();

                Integer t1 = trafficSum.get(timeString);
                if (t1 == null) t1=0;

                System.out.println(timeString);
                trafficSum.put(timeString, t1 + 1);
                traffic.put(i+1 + timeString, timeString);
            }

        }
        String key = Collections.max(trafficSum.entrySet(), Map.Entry.comparingByValue()).getKey();

        int maxValueInMap = (Collections.max(trafficSum.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : trafficSum.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }


//        Integer teste2 = trafficSum.get("09:30");
        String test = traffic.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), key))
                .map(m -> m.getKey().substring(0, 1))
                .sorted()
                .collect(Collectors.joining(","));

        return String.format("%s(%s)", key, test);

    }

    public static void runCode() {
        System.out.println(getResult(Arrays.asList(15, 8, 9, 7, 14 )));
        System.out.println(getResult(Arrays.asList(5, 20, 15, 0, 7, 16 )));
        ;
        // Entrypoint to debug your function
    }

    public static void main(String[] args) {
        runCode();
    }
}
