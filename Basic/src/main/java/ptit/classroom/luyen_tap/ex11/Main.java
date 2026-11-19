package ptit.classroom.luyen_tap.ex11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static Object TreeSet;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> ds = new ArrayList<>();
        ds = (ArrayList<String>) in.readObject();

        Set<Integer> se = new TreeSet<>();

        for (String line : ds) {
            String[] words = line.trim().split("\\s+");
            for (String word : words) {
                try {
                    int num = Integer.parseInt(word);
                    se.add(num);
                } catch (NumberFormatException e) {

                }
            }
        }

        for (int num : se) {
            System.out.println(num);
        }

        in.close();
    }
}
