import java.io.IOException;

public class Quiz2 {
    public static void main(String[] args) throws IOException {
        Person resourceUser = new Person("data.txt");
        resourceUser.writeData("This is some test data.");
        resourceUser = null;
         System.gc();
    }
}