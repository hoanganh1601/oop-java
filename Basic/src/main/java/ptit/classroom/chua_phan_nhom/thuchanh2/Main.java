package ptit.classroom.chua_phan_nhom.thuchanh2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];

        double maxScore = -1.0;
        double minScore = 11.0;

        for (int i = 0; i < n; ++i) {
            scores[i] = sc.nextDouble();
            if(scores[i] > maxScore) maxScore = scores[i];
            if(scores[i] < minScore) minScore = scores[i];
        }

        double sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if(scores[i] != maxScore && scores[i] != minScore) {
                sum += scores[i];
                cnt += 1;
            }
        }

        double averageScore = sum / cnt;
        System.out.printf("%.2f", averageScore);
    }
}
