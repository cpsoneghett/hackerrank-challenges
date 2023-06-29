package june28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BillDivision {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/bill-division.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }

    private static void bonAppetit(List<Integer> bill, int k, int b) {

        int totalBill = bill.stream().mapToInt(Integer::intValue).sum();

        int totalMinusAnna = (totalBill - bill.get(k))/2;

        if(totalMinusAnna >= b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - totalMinusAnna);
        }

    }
}
