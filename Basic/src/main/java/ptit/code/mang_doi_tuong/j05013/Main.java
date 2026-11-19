package ptit.code.mang_doi_tuong.j05013;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Candidate> candidateList = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            Candidate candidate = new Candidate(i, sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();
            candidateList.add(candidate);
        }

        Collections.sort(candidateList, new Comparator<Candidate>(){
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return Double.compare(o2.getAverageScore(), o1.getAverageScore());
            }
        });

        for (Candidate candidate : candidateList) {
            System.out.println(candidate);
        }
    }
}
