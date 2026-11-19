package ptit.classroom.chua_phan_nhom.kiemtra8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static boolean isDau(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static long cal(String op, long op1, long op2) {
        switch (op) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            String[] tokens = new String[n];

            for (int i = 0; i < n; i++) {
                tokens[i] = scanner.next();
            }

            Deque<Long> st = new ArrayDeque<>();

            for (int i = n - 1; i >= 0; i--) {
                String token = tokens[i];

                if (isDau(token)) {
                    long op1 = st.pop();
                    long op2 = st.pop();
                    long result = cal(token, op1, op2);
                    st.push(result);
                }
                else {
                    st.push(Long.parseLong(token));
                }
            }

            System.out.println(st.pop());
        }

        scanner.close();
    }
}