import java.util.Arrays;
import java.util.Vector;

public class LCSOptimized {

    public static void main(String[] args) {
        Vector<Character> X = new Vector<>(Arrays.asList('A', 'R', 'C', 'B', 'D', 'A', 'B'));
        Vector<Character> Y = new Vector<>(Arrays.asList('B', 'D', 'C', 'A', 'B', 'A'));

        int lcsLength = lcsLengthOptimized(X, Y);
        System.out.println("Length of LCS: " + lcsLength);
    }

    public static int lcsLengthOptimized(Vector<Character> X, Vector<Character> Y) {
        int m = X.size();
        int n = Y.size();

        Vector<Integer> c = new Vector<>(n + 1);
        Vector<Character> b = new Vector<>(n + 1);

        Arrays.fill(c.toArray(), 0);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.get(i - 1) == Y.get(j - 1)) {
                    c.set(j, c.get(j - 1) + 1);
                    b.set(j, '\\');
                } else if (c.get(j) >= c.get(j - 1)) {
                    c.set(j, c.get(j));
                    b.set(j, '-');
                } else {
                    c.set(j, c.get(j - 1));
                    b.set(j, '|');
                }
            }
        }

        return c.get(n);
    }
}
