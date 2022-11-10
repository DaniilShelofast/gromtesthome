package lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 extends RuntimeException {
    public static void main(String[] args) throws IOException {
        System.out.println(readInt());
    }


    public static int readInt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException ex) {
            return 0;
        }finally {
            reader.close();

        }
    }

}
