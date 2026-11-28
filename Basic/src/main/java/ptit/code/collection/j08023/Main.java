package ptit.code.collection.j08023;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            int[] trai = new int[n];
            Stack<Integer> stTrai = new Stack<>();
            for (int i = 0; i < n; ++i) {
                while(!stTrai.isEmpty() && arr[i] <= arr[stTrai.peek()]) {
                    stTrai.pop();
                }

                if(stTrai.isEmpty()) {
                    trai[i] = -1;
                }
                else {
                    trai[i] = stTrai.peek();
                }
                stTrai.push(i);
            }

            int[] phai = new int[n];
            Stack<Integer> stPhai = new Stack<>();
            for (int i = n - 1; i >= 0; --i) {
                while(!stPhai.isEmpty() && arr[i] <= arr[stPhai.peek()]) {
                    stPhai.pop();
                }

                if(stPhai.isEmpty()) {
                    phai[i] = n;
                }
                else {
                    phai[i] = stPhai.peek();
                }
                stPhai.push(i);
            }

//            for (int i = 0; i < n; ++i) {
//                System.out.print(trai[i] + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < n; ++i) {
//                System.out.print(phai[i] + " ");
//            }
//            System.out.println();

            long res = -1;
            for (int i = 0; i < n; ++i) {
                res = Math.max(res, 1L * (phai[i] - trai[i] - 1) * arr[i]);
            }
            System.out.println(res);
        }
    }
}
