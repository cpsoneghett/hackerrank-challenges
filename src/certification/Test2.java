package certification;

public class Test2 {

    public static void main(String[] args) {
        int i = 0;
        for(System.out.print(i++); i < 2; System.out.print(i++)) {
            System.out.print(i);
        }

        Person p1 = new Person("Chris", 31);
        Person p2 = new Person("Chris", 31);

        Person p3 = p1;

        System.out.println();

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p3 == p1);
        System.out.println(p3.equals(p1));
    }
}
