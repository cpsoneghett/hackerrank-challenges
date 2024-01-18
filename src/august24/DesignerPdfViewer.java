package august24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DesignerPdfViewer {

    public static int designerPdfViewer(List<Integer> h, String word) {

        char[] arr = word.toCharArray();
        int size = word.length();
        int height = 0;

        for (char c : arr) {
            int position = c - 'a';
            if(h.get(position) > height)
                height = h.get(position);
        }

        return size * height;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/inputs/pdfviewer.txt"));

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        String word = bufferedReader.readLine();

        int result = designerPdfViewer(h, word);

        System.out.println(result);
        bufferedReader.close();
    }
}
