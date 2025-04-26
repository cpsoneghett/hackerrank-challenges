import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClearOps {

    public static void main(String[] args) {
        List<String> logs = List.of(
                "1672545600,user1,LOGIN",
                "1672545601,user2,CLICK",
                "1672545602,user1,CLICK",
                "1672545603,user1,CLICK",
                "1672545604,user2,LOGIN"
        );

        Map<String, Map<String, Integer>> userOperationsMap = new HashMap<>();

        for (String s : logs) {

            String[] aux = s.split(",");

            userOperationsMap.computeIfAbsent(aux[1], k -> new HashMap<>());

            Map<String, Integer> map = userOperationsMap.get(aux[1]);
            map.put(aux[2], map.getOrDefault(aux[2], 0) + 1);
        }

        int big = 0;
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> userEntry : userOperationsMap.entrySet()) {

            Map<String, Integer> value = userEntry.getValue();
            sb.append(userEntry.getKey()).append(" -> ");

            String ref = "";
            for (Map.Entry<String, Integer> valueEntry : value.entrySet()) {

                if (valueEntry.getValue() > big) {
                    big = valueEntry.getValue();
                    ref = valueEntry.getKey();
                }

            }
            sb.append(ref);
            output.add(sb.toString());
            sb.setLength(0);
            big = 0;
        }

        System.out.println(output);
//Expected: { "user1" -> "CLICK", "user2" -> "LOGIN" }
    }
}
