package ptit.classroom.chua_phan_nhom.thuchanh4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] isCheck = new boolean[n + 1];
        List<Integer> loi = new ArrayList<>();
        List<Integer> good = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            int num = sc.nextInt();
            isCheck[num] = true;
            loi.add(num);
        }

        for (int i = 1; i <= n; ++i) {
            if(!isCheck[i]) {
                good.add(i);
            }
        }

        System.out.println("Errors: " + format(loi));
        System.out.println("Correct: " + format(good));

        sc.close();
    }

    public static String format(List<Integer> list) {
        if(list.isEmpty()) return "";

        List<String> tmp = new ArrayList<>();
        int start = list.get(0);
        int prev = start;

        for (int i = 1; i < list.size(); ++i) {
            int cur = list.get(i);
            if(cur == prev + 1) {
                prev = cur;
            }
            else {
                if(start == prev) {
                    tmp.add(String.valueOf(start));
                }
                else {
                    tmp.add(start + "-" + prev);
                }

                start = cur;
                prev = cur;
            }
        }

        if(start == prev) {
            tmp.add(String.valueOf(start));
        }
        else {
            tmp.add(start + "-" + prev);
        }

        if(tmp.size() == 1) return tmp.get(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.size() - 1; ++i) {
            sb.append(tmp.get(i));
            if(i < tmp.size() - 2) {
                sb.append(", ");
            }
        }
        sb.append(" and ").append(tmp.get(tmp.size() - 1));
        return sb.toString();
    }
}