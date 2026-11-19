package ptit.classroom.thuc_hanh_02.bai_04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
    public static boolean isGood(int num) {
        int last = num % 10;
        num /= 10;
        while(num > 0) {
            int prev = num % 10;
            if (prev > last) return false;
            last = prev;
            num /= 10;
        }

        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        int[] cnt1 = new int[10000];
        int[] cnt2 = new int[10000];

        for (int x : list1) {
            if(x >= 10 && x <= 9999) cnt1[x]++;
        }

        for (int x : list2) {
            if(x >= 10 && x <= 9999) cnt2[x]++;
        }

        for (int i = 10; i <= 9999; ++i) {
            if(cnt1[i] > 0 && cnt2[i] > 0 && isGood(i)) {
                System.out.println(i + " " + cnt1[i] + " " + cnt2[i]);
            }
        }
    }
}
