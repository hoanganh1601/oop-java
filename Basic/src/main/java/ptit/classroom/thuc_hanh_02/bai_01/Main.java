package ptit.classroom.thuc_hanh_02.bai_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= MAX; ++i) {
            if(isPrime[i]){
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sieve();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DAYSO.DAT"));
        ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();
        ois.close();

        Set<Integer> se = new TreeSet<>();
        for (int num : list) {
            if(num >= 100 && isPrime[num]) se.add(num);
        }

        for (int prime : se) {
            System.out.println(prime);
        }
    }
}
