package ptit.code.mang_doi_tuong.j05009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Candidate> candidateList = new ArrayList<>();

        double res = 0.0;
        for (int i = 1; i <= n; ++i) {
            Candidate tmp = new Candidate(i, sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();
            res = Math.max(res, tmp.getTotalScore());
            candidateList.add(tmp);
        }

        for (Candidate tmp : candidateList) {
            if(tmp.getTotalScore() == res) {
                System.out.println(tmp);
            }
        }
    }
}
