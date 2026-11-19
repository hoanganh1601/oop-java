package ptit.classroom.thuc_hanh_02.bai_06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<String> list1 = (ArrayList<String>) ois1.readObject();
        ois1.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();

        TreeSet<String> se1 = new TreeSet<>(list1);
        TreeSet<Integer> se2 = new TreeSet<>(list2);

        for(String s : se1) {
            for (int num : se2) {
                System.out.println(s + "" + num);
            }
        }
    }
}
