package ptit.code.collection.j08024;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static long solve(int num) {
        Queue<Long> q = new ArrayDeque<>();
        q.offer(9L);

        while(!q.isEmpty()) {
            long x = q.poll();
            if (x % num == 0) {
                return x;
            }

            q.offer(x * 10);
            q.offer(x * 10 + 9);
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
        sc.close();
    }
}
