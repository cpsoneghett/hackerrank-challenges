package leetcode.interview.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums)
            set.add(n);

        return 0;

    }

    public static String extractYear(String input) {
        // Regex to match a 4-digit number (assuming year is 1000-2999)
        String regex = "\\b(\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find and return the first 4-digit number found (assumed to be the year)
        if (matcher.find()) {
            return matcher.group(1); // group(1) is the year
        }

        // If no year found, return a message (or null)
        return "No year found";
    }

    public static void main(String[] args) {
        String a = "Núm. 90 (2019): Enero-Junio";
        String b = "N° 50: JULIO-DICIEMBRE 2006";
        String c = "Núm. 79 (2016): Revista Facultad de Ingeniería (Abr-Jun 2016)";
        String d = "N° 53: ENERO-JUNIO 2008";

        System.out.println(extractYear(a));  // Output: 2019
        System.out.println(extractYear(b));  // Output: 2006
        System.out.println(extractYear(c));  // Output: 2016
        System.out.println(extractYear(d));
    }
}
