import testFinalize.Finalizable;

import java.io.FileOutputStream;
import java.io.IOException;

public class Person implements Finalizable {

    private final FileOutputStream outputStream; // Replace with appropriate resource

    public Person(String filePath) throws IOException {
        outputStream = new FileOutputStream(filePath);
    }

    public void writeData(String data) throws IOException {
        outputStream.write(data.getBytes());
    }

    @Override
    public void finalize() throws Throwable {
        try {
            outputStream.close(); // Close resource
        } finally {
            super.finalize(); // Call finalizer of superclass
        }
    }


}
