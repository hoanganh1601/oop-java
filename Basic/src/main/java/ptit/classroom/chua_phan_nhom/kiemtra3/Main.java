package ptit.classroom.chua_phan_nhom.kiemtra3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static final int MAX = 1000000;
    static boolean[] mark = new boolean[MAX + 1];

    public static boolean check(int num) {
        int rev = 0;
        int tmp = num;

        while(tmp > 0) {
            rev = rev * 10 + tmp % 10;
            tmp /= 10;
        }

        return rev == num;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();

        Arrays.fill(mark, false);
        for (int num : list) {
            if(num >= 100 && num <= MAX) {
                mark[num] = true;
            }
        }

        for (int i = 100; i <= MAX; ++i) {
            if(mark[i] && check(i)) {
                System.out.println(i);
            }
        }
    }
}