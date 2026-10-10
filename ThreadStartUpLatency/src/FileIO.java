import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileIO {
    private static final String HEADER = "N,Thread,Runnable";

    public static void write(String path, double n, double thread, double runnable){

        Path file = Path.of(path);
        boolean isNew = Files.notExists(file);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
            if (isNew){
                writer.write(HEADER);
            }
            writer.newLine();
            writer.write(n + "," + thread + "," + runnable);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
