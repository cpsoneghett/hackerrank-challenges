package june28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayOfProgrammer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/years.txt"));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);

        bufferedReader.close();
    }

    private static String dayOfProgrammer2(int yearNumber) {

        LocalDate date = LocalDate.ofYearDay(yearNumber, 256);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return date.format(formatter);
    }

    private static String dayOfProgrammer(int year) {

        if (year > 1918) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
                return "12.09." + year;
            else
                return "13.09." + year;
        } else if (year < 1918) {
            if (year % 4 == 0)
                return "12.09." + year;
            else
                return "13.09." + year;
        } else
            return "26.09." + year;

    }
}
