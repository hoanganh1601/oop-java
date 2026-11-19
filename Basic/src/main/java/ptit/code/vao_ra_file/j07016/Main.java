package ptit.code.vao_ra_file.j07016;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int MAX = 10001;
    private static boolean[] isPrime = new boolean[MAX];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; ++i) {
            if(isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) isPrime[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();

        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        int[] cnt1 = new int[MAX];
        int[] cnt2 = new int[MAX];

        for (int num : list1) {
            if(isPrime[num]) ++cnt1[num];
        }
        for (int num : list2) {
            if(isPrime[num]) ++cnt2[num];
        }

        for (int i = 2; i < MAX; ++i) {
            if(cnt1[i] > 0 && cnt2[i] > 0) {
                System.out.println(i + " " + cnt1[i] + " " + cnt2[i]);
            }
        }
    }
}
