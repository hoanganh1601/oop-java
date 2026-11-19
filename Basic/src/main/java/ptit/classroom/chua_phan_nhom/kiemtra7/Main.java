package ptit.classroom.chua_phan_nhom.kiemtra7;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int MAX = 10000;
    private static String[] list = new String[MAX];

    public static void init() {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("4");
        queue.add("5");

        int cnt = 0;
        while(cnt < MAX) {
            String half = queue.poll();

            StringBuilder sb = new StringBuilder(half);
            String full = half + sb.reverse().toString();
            list[cnt++] = full;
            queue.add(half + "4");
            queue.add(half + "5");
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int num = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; ++i) {
                sb.append(list[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }

    }
}
