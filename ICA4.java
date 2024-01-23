import java.util.Vector;
import java.util.Random;

public class ICA4 {

    public static int randomizedSelect(Vector<Integer> A, int p, int r, int i) {
        if (p == r) {
            return A.get(p);
        }

        int q = randomizedPartition(A, p, r);
        if (i == q) {
            return A.get(q);
        } else if (i < q) {
            return randomizedSelect(A, p, q - 1, i);
        } else {
            return randomizedSelect(A, q + 1, r, i - q - 1);
        }
    }

    public static int randomizedPartition(Vector<Integer> A, int p, int r) {
        Random random = new Random();
        int i = random.nextInt(r - p + 1) + p; // Choose a random index

        // Swap A[i] and A[r]
        int temp = A.get(i);
        A.set(i, A.get(r));
        A.set(r, temp);

        return partition(A, p, r);
    }

    public static int partition(Vector<Integer> A, int p, int r) {
        int x = A.get(r);
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A.get(j) <= x) {
                i++;
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
            }
        }
        int temp = A.get(i + 1);
        A.set(i + 1, A.get(r));
        A.set(r, temp);
        return i + 1;
    }

    public static void main(String[] args) {
        Vector<Integer> A = new Vector<>();
        // Add elements to the vector A

        int i = 3; // Example: Find the 3rd smallest element
        int result = randomizedSelect(A, 0, A.size() - 1, i);
        System.out.println("The " + i + "th smallest element is: " + result);
    }
}
