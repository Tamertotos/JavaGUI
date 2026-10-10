import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static void write(String path, double n, double thread, double runnable){

        List<Double> rows = new ArrayList<Double>();
        rows.add(n);
        rows.add(thread);
        rows.add(runnable);

        boolean isNew = Files.notExists(Path.of(path));

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
            if (isNew){
                writer.write("N,Thread,Runnable");
            }
            writer.newLine();
            writer.write(rows.get(0) + "," + rows.get(1) + "," + rows.get(2));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
