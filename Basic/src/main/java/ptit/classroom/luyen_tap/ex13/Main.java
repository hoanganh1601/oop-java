package ptit.classroom.luyen_tap.ex13;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
    public static boolean isNonDecreasing(int n) {
        if (n < 10) return false;

        int prevDigit = n % 10;
        n /= 10;

        while (n > 0) {
            int currDigit = n % 10;
            if (currDigit > prevDigit) {
                return false;
            }
            prevDigit = currDigit;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) in1.readObject();
        in1.close();

        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) in2.readObject();
        in2.close();

        int[] count1 = new int[10005];
        int[] count2 = new int[10005];

        for (Integer num : list1) {
            if (isNonDecreasing(num)) {
                count1[num]++;
            }
        }

        for (Integer num : list2) {
            if (isNonDecreasing(num)) {
                count2[num]++;
            }
        }

        for (int i = 10; i <= 9999; i++) {
            if (count1[i] > 0 && count2[i] > 0) {
                System.out.println(i + " " + count1[i] + " " + count2[i]);
            }
        }
    }
}
