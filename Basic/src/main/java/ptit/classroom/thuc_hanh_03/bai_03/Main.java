package ptit.classroom.thuc_hanh_03.bai_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int test = sc.nextInt();
        for (int t = 1; t <= test; ++t) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            long num1 = 0, num2 = 0;
            for (int i = 0; i < n; ++i) {
                if(i % 2 == 0) {
                    num1 = num1 * 10 + arr[i];
                }
                else {
                    num2 = num2 * 10 + arr[i];
                }
            }
            System.out.println(num1 + num2);
        }
    }
}
