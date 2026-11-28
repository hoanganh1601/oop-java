package ptit.code.collection.j08020;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static boolean checkValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            if(x == '(' || x == '[' || x == '{') {
                st.push(x);
            }
            else {
                if(st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if(x == '}' && top != '{') return false;
                if(x == ']' && top != '[') return false;
                if(x == ')' && top != '(') return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            String s = sc.next();
            if(checkValid(s)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
