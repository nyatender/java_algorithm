package MyUtils;
import java.io.*;
import java.util.StringTokenizer;

public class StringInputOutPutOperations {
    public void InputOutPutReader() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }

}

class GfG
{
    public static void characterStream() throws IOException
    {
        FileReader sourceStream = null;
        try
        {
            sourceStream = new FileReader("test.txt");

            // Reading sourcefile and writing content to
            // target file character by character.
            int temp;
            while ((temp = sourceStream.read()) != -1)
                System.out.println((char)temp);
        }
        finally
        {
            // Closing stream as no longer in use
            if (sourceStream != null)
                sourceStream.close();
        }
    }
}

class FileInputStreamExample {
    public void test() throws IOException {
        FileInputStream sourceStream = null;
        FileOutputStream targetStream = null;

        try {
            sourceStream = new FileInputStream("sorcefile.txt");
            targetStream = new FileOutputStream("targetfile.txt");

            // Reading source file and writing content to target
            // file byte by byte
            int temp;
            while ((temp = sourceStream.read()) != -1)
                targetStream.write((byte) temp);
        } finally {
            if (sourceStream != null)
                sourceStream.close();
            if (targetStream != null)
                targetStream.close();
        }
    }
}

