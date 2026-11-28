package ptit.code.vao_ra_file.j07023;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final int MAX = 10000;
    private static boolean[] prime = new boolean[MAX];

    public static void sieve() {
        Arrays.fill(prime, true);
        prime[0] = false; prime[1] = false;
        for (int i = 2; i * i < MAX; ++i) {
            if(prime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static boolean isPalidrome(int n) {
        String tmp = String.valueOf(n);
        int left = 0, right = tmp.length() - 1;

        while(left < right) {
            if(tmp.charAt(left) != tmp.charAt(right)) return false;
            ++left; --right;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DATA1.in")));
        ArrayList<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DATA2.in")));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        sieve();

        int[] cnt1 = new int[MAX];
        int[] cnt2 = new int[MAX];

        for (int x : list1) ++cnt1[x];
        for (int x : list2) ++cnt2[x];

        for (int i = 2; i < MAX; ++i) {
            if(cnt1[i] > 0 && cnt2[i] > 0 && prime[i] && isPalidrome(i)) {
                System.out.println(i + " " + cnt1[i] + " " + cnt2[i]);
            }
        }
    }
}
