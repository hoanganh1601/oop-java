package ptit.code.vao_ra_file.j07015;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final int MAX = 10001;
    private static boolean[] isPrime = new boolean[MAX];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();

        int[] mark = new int[MAX];
        for (int x : list) {
            if (x < MAX && isPrime[x]) {
                ++mark[x];
            }
        }

        for (int i = 2; i < MAX; ++i) {
            if (mark[i] > 0) {
                System.out.println(i + " " + mark[i]);
            }
        }
    }
}