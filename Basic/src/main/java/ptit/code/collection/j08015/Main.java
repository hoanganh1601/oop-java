package ptit.code.collection.j08015;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            Map<Long, Integer> mp = new HashMap<>();
            long res = 0;
            for (int i = 0; i < n; ++i) {
                long x = sc.nextLong();
                long target = k - x;
                res += mp.getOrDefault(target, 0);

                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
            System.out.println(res);
        }
    }
}
