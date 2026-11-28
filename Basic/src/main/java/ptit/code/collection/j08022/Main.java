package ptit.code.collection.j08022;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] res = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }

            Stack<Integer> st = new Stack<>();
            for (int i = n - 1; i >= 0; --i) {
                while(!st.isEmpty() && arr[i] >= st.peek()) {
                    st.pop();
                }

                if(st.isEmpty()) {
                    res[i] = -1;
                }
                else {
                    res[i] = st.peek();
                }

                st.push(arr[i]);
            }

            for (int i = 0; i < n; ++i) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
