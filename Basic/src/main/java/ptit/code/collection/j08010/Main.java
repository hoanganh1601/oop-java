package ptit.code.collection.j08010;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static boolean palidrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left; --right;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mp = new LinkedHashMap<>();
        int maxLength = -1;

        while(sc.hasNext()) {
            String s = sc.next();
            if(palidrome(s)) {
                mp.put(s, mp.getOrDefault(s, 0) + 1);
                maxLength = Math.max(maxLength, s.length());
            }
        }

        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getKey().length() == maxLength) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        sc.close();
    }
}
