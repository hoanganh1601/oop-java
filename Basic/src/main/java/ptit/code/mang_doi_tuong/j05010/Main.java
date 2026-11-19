package ptit.code.mang_doi_tuong.j05010;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Goods> goodsList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            Goods tmp = new Goods(i, sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();
            goodsList.add(tmp);
        }

        Collections.sort(goodsList, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return Double.compare(o2.getProfit(), o1.getProfit());
            }
        });

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
