package ptit.code.mang_doi_tuong.j05015;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Cyclist> cyclistList = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            Cyclist cyclist = new Cyclist(sc.nextLine(), sc.nextLine(), sc.nextLine());
            cyclistList.add(cyclist);
        }

        Collections.sort(cyclistList, new Comparator<Cyclist>() {
            @Override
            public int compare(Cyclist o1, Cyclist o2) {
                return o1.getTotalMinutes() - o2.getTotalMinutes();
            }
        });

        for(Cyclist cyclist : cyclistList) {
            System.out.println(cyclist);
        }
    }
}
