package ptit.code.collection.j08011;

import java.util.*;

public class Main {

    private static boolean checkValid(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> mp = new LinkedHashMap<>();
        while(sc.hasNext()) {
            String num = sc.next();
            if(checkValid(num)) mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        sc.close();

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
