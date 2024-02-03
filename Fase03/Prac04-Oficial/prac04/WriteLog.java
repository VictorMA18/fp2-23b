import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {
    public static synchronized void writeFile(String t) {
		try {
		  FileWriter myWriter = new FileWriter("my_log_name.log", true);
		  myWriter.write(t + "\n");
		  myWriter.close();
		} catch (IOException e) {
		  System.out.println("Hubo un error.");
		  e.printStackTrace();
		}
    }
}