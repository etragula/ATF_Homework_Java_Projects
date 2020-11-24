package pack;

import java.io.FileReader;
import java.io.IOException;

public class File_Reader {

    public static String readerMethod(String path) {
        char[] buf = new char[512];
        String str = null;

        try {
            FileReader readerMethod = new FileReader(path);
            readerMethod.read(buf);
            str = String.valueOf(buf);
            readerMethod.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Файл не найден. Попробуйте еще раз.");
        }
        return str;
    }
}
