package certification;

public class Test {

    public static void main(String[] args) {
        String [][] countries = {{"SINGAPORE", "AUSTRALIA"}, {"CHINA", "RUSSIA"}};
        /*INSERT*/

        for (int i = 0; i < countries.length; i++) {
            for (int j = 0; j < countries[i].length; j++) {
                System.out.print(countries[i][j] + " ");
            }
        }

        System.out.println();
        for (String[] arr : countries) {
            for(String country : arr)
                System.out.print(country + " ");
        }
        System.out.println();



        var var = 0; //Line n1
        var: for (; var < 3; var++) {  //Line n2
            if (var % 2 == 0) {
                continue var; //Line n3
            }
            var++; //Line n4
        }
        System.out.println(var);


        /*
        int i;
        outer:
        do {
            i = 5;
            inner:
            while (true) {
                System.out.println(i--);
                if (i == 4) {
                    break outer; // Moved the break statement to be inside the labeled block
                }
            }
        } while (true);

         */

    }

}
