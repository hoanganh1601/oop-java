package ptit.classroom.thuc_hanh_02.bai_13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();

        TreeSet<Integer> se = new TreeSet<>();

        for (String line : list) {
            StringTokenizer st = new StringTokenizer(line);
            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                try {
                    int val = Integer.parseInt(token);
                    se.add(val);
                } catch (NumberFormatException n) {

                }
            }
        }

        for (int num : se) {
            System.out.println(num);
        }
    }
}
