import java.io.*;
public class FileWrite {
    public void WriteToFile(String s) {
        FileWriter out = new FileWriter("save.txt");
        out.write(s);
    }
}