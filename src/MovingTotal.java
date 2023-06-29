import java.util.HashSet;

public class MovingTotal {

    private HashSet<Integer> totals;
    private int[] elements;
    private int currentIndex;

    public MovingTotal() {
        this.totals = new HashSet<>();
        this.elements = new int[3];
        this.currentIndex = 0;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3, 4});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[]{5});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }

    /**
     * Adds/appends list of integers at the end of the internal list.
     */
    public void append(int[] list) {
        for (int num : list) {
            if (currentIndex == 3) {
                int sum = elements[0] + elements[1] + elements[2];
                totals.add(sum);
                shiftElements(num);
            } else {
                elements[currentIndex] = num;
                currentIndex++;
            }
        }
    }

    /**
     * Returns a boolean representing if any three consecutive integers in the
     * internal list have the given total.
     */
    public boolean contains(int total) {
        if (totals.contains(total)) {
            return true;
        }

        if (currentIndex == 3) {
            int sum = elements[0] + elements[1] + elements[2];
            if (sum == total) {
                return true;
            }
        }

        return false;
    }

    private void shiftElements(int num) {
        for (int i = 0; i < 2; i++) {
            elements[i] = elements[i + 1];
        }
        elements[2] = num;
    }
}