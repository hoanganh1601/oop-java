package ptit.code.collection.j08012;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 1; i <= n - 1; ++i) {
            int u = sc.nextInt(), v = sc.nextInt();
            mp.put(u, mp.getOrDefault(u, 0) + 1);
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }

        boolean check = false;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() == n - 1) {
                check = true;
                System.out.println("Yes");
                break;
            }
        }
        if(!check) {
            System.out.println("No");
        }
    }
}
