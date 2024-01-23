import java.util.Vector;

public class ICA3 {

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

        public static void main(String[] args) {

            Vector<Integer> array = new Vector<>();
            array.add(1);
            array.add(0);
            array.add(1);

            System.out.println("Original Array: " + array);
            Vector<Integer> result = increment(array);
            System.out.println("Incremented Array: " + result);
        }
    }


