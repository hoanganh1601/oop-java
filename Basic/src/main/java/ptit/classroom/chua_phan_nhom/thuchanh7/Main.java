package ptit.classroom.chua_phan_nhom.thuchanh7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> set;
    public WordSet(String line) {
        set = new TreeSet<>();
        String[] words = line.trim().toLowerCase().split("\\s+");
        set.addAll(Arrays.asList(words));
    }

    private WordSet(TreeSet<String> set) {
        this.set = set;
    }

    public WordSet union(WordSet other) {
        TreeSet<String> resSet = new TreeSet<>(this.set);
        resSet.addAll(other.set);
        return new WordSet(resSet);
    }

    public WordSet intersection(WordSet other) {
        TreeSet<String> resSet = new TreeSet<>(this.set);
        resSet.retainAll(other.set);
        return new WordSet(resSet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String w : set) {
            sb.append(w).append(" ");
        }
        return sb.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("VANBAN.in"));
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
