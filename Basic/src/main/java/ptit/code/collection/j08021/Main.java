package ptit.code.collection.j08021;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            String s = sc.next();
            // store idx
            Stack<Integer> st = new Stack<>();
            st.push(-1);

            int res = -1;
            for (int i = 0; i < s.length(); ++i) {
                char x = s.charAt(i);
                if (x == '(') {
                    st.push(i);
                }
                else {
                    st.pop();

                    if(st.isEmpty()) {
                        st.push(i);
                    }
                    else {
                        res = Math.max(res, i - st.peek());
                    }
                }
            }
            System.out.println(res);
        }
    }
}
