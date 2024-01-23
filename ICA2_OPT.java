import java.util.Vector;

public class ICA2_OPT {

    public static int optimizedBinarySearch(Vector<Integer> A, int T) {
        int n = A.size();
        int L = 0;
        int R = n - 1;

        while (L <= R) {
            int m = (L + R) / 2;

            if (A.get(m) == T)
                return m;
            else if (A.get(m) < T)
                L = m + 1;
            else
                R = m - 1;
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        // Example usage:
        Vector<Integer> array;
        array = new Vector<>();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        int target = 3;
        int result = optimizedBinarySearch(array, target);

        if (result != -1) {
            System.out.println("Found at index " + result);
        } else {
            System.out.println("Not found in array");
        }
    }
}
