package MyUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileImputOperations {

    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        String path = "D:\\Educative\\project\\springboot apps\\springBoot_Apps\\java_algorithm\\src\\MyUtils";

        try {
            in = new FileInputStream(path+"\\input.txt");
            out = new FileOutputStream(path + "\\output.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}