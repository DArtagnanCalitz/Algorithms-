import java.util.Arrays;
import java.util.Vector;

public class ICA3_PAUSE {

    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> counter = new Vector<>(8);

        // Initialize counter with zeros
        for (int i = 0; i < 8; i++) {
            counter.add(0);
        }

        // Print initial value
        System.out.println(counter);

        while (!counter.equals(new Vector<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)))) {

        counter = increment(counter);
            System.out.println(counter);
            Thread.sleep(2000); // Pause for 2 seconds
        }
    }

    public static Vector<Integer> increment(Vector<Integer> A) {
        int i = 0;
        while (i < A.size() && A.get(i) == 1) {
            A.set(i, 0);
            i = i + 1;
        }
        if (i < A.size()) {
            A.set(i, 1);
        }
        return A;
    }
}
