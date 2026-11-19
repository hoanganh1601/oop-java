package ptit.classroom.thuc_hanh_03.bai_09;

import java.util.*;

public class Main {
    static int MAXN = 10000;
    static List<String> res = new ArrayList<>();

    public static void init() {
        Queue<String> q = new ArrayDeque<>();
        q.add("4");
        q.add("5");

        while(res.size() < MAXN) {
            String first = q.poll();
            StringBuilder sb = new StringBuilder(first);
            String rev = sb.reverse().toString();
            res.add(first + rev);

            q.add(first + "4");
            q.add(first + "5");
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int num = sc.nextInt();
            for (int i = 0; i < num; ++i) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
