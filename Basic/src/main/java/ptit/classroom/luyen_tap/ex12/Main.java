package ptit.classroom.luyen_tap.ex12;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        else if (n == 2 || n == 3) return true;
        else if (n % 2 == 0 || n % 3 == 0) return false;
        else {
            for (int i = 5; i * i <= n; i += 6) {
                if(n % i == 0 || n % (i + 2) == 0) return false;
            }
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

        for (Integer x : list1) {
            if (isPrime(x)) {
                count1[x]++;
            }
        }

        for (Integer x : list2) {
            if (isPrime(x)) {
                count2[x]++;
            }
        }

        for (int i = 2; i <= 10000; i++) {
            if (count1[i] > 0 && count2[i] > 0) {
                System.out.println(i + " " + count1[i] + " " + count2[i]);
            }
        }
    }
}
