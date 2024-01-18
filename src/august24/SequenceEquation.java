package august24;

import java.util.ArrayList;
import java.util.List;

public class SequenceEquation {

    public static List<Integer> permutationEquation(List<Integer> p) {

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= p.size(); i++) {
            result.add(p.indexOf(p.indexOf(i) + 1) + 1);
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> a = List.of(4, 3, 5, 1, 2);

        System.out.println(permutationEquation(a));
    }
}
