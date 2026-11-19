package ptit.code.vao_ra_file.j07005;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        int[] cnt = new int[1000];

        for (int i = 0; i < 100000; ++i) {
            int n = dis.readInt();
            ++cnt[n];
        }

        for (int i = 0; i < 1000; ++i) {
            if(cnt[i] > 0) {
                System.out.println(i + " " + cnt[i]);
            }
        }

        dis.close();
    }
}
