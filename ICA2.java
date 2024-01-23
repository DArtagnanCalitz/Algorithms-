import java.util.Vector;
public class ICA2 {

    public static int binarySearch(Vector<Integer> A, int T) {
        int n = A.size();
        int L = 0;
        int R = n - 1;

        while (L <= R) {
            int m = (L + R) / 2;

            if (A.get(m) < T)
                L = m + 1;
            else if (A.get(m) > T)
                R = m - 1;
            else
                return m;
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
        int result = binarySearch(array, target);

        if (result != -1) {
            System.out.println("Found at index " + result);
        } else {
            System.out.println("Not found in array");
        }
    }
}


