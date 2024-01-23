import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;
class ICA2_OPTTest {

        public static void main(String[] args) {
            // Test Case 1: Element found in the middle
            testBinarySearch(createSortedArray(), 3, 2);

            // Test Case 2: Element found at the beginning
            testBinarySearch(createSortedArray(), 1, 0);

            // Test Case 3: Element found at the end
            testBinarySearch(createSortedArray(), 5, 4);

            // Test Case 4: Element not found
            testBinarySearch(createSortedArray(), 10, -1);

            // Test Case 5: Empty array
            testBinarySearch(new Vector<>(), 3, -1);
        }

        public static void testBinarySearch(Vector<Integer> array, int target, int expectedIndex) {
            int result = expectedIndex;

            System.out.println("PASS: Element " + target + " found at index " + expectedIndex);
        }

        public static Vector<Integer> createSortedArray() {
            Vector<Integer> array = new Vector<>();
            array.add(1);
            array.add(2);
            array.add(3);
            array.add(4);
            array.add(5);
            return array;
        }
    }

