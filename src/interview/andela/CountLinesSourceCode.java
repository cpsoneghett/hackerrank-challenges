package interview.andela;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLinesSourceCode {

    public static long countCodeLines(String fileNamePath) throws IOException {

        int blankLines = 0;
        int codeLines = 0;
        int commentLines = 0;
        boolean inBlockComments = false;

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileNamePath));
            for (String line : lines) {
                String trimmedLine = line.trim();

                if (trimmedLine.startsWith("/*"))
                    inBlockComments = true;

                if (trimmedLine.contains("//") || inBlockComments)
                    commentLines++;
                else if (trimmedLine.isEmpty())
                    blankLines++;
                else
                    codeLines++;

                if (trimmedLine.endsWith("*/"))
                    inBlockComments = false;

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return codeLines;
        }

    }

    public static void main(String[] args) throws IOException {

        System.out.println("Number of code lines: " + countCodeLines("src/AbbreviationChallenge.java"));

    }
}

