package ptit.code.mang_doi_tuong.j05012;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Goods> goodsList = new ArrayList<>();

        for(int i = 1; i <= n; ++i) {
            Goods goods = new Goods(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong(), sc.nextLong());
            sc.nextLine();

            goodsList.add(goods);
        }

        Collections.sort(goodsList, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return Long.compare(o2.getTotalAmount(), o1.getTotalAmount());
            }
        });

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
}
