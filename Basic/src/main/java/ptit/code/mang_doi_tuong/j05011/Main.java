package ptit.code.mang_doi_tuong.j05011;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        List<Gamer> gamerList = new ArrayList<>();
        while(test-- > 0) {
            Gamer gamer = new Gamer(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            gamerList.add(gamer);
        }

        Collections.sort(gamerList, new Comparator<Gamer>() {
            @Override
            public int compare(Gamer o1, Gamer o2) {
                return o2.getPlayTime() - o1.getPlayTime();
            }
        });

        for(Gamer gamer : gamerList) {
            System.out.println(gamer);
        }
    }
}
