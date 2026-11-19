package ptit.classroom.chua_phan_nhom.kiemtra2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> words = new TreeSet<>();

    public WordSet(String line) {
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens()) {
            words.add(st.nextToken().toLowerCase());
        }
    }

    public String union(WordSet other) {
        TreeSet<String> unionSet = new TreeSet<>(this.words);
        unionSet.addAll(other.words);
        return String.join(" ", unionSet);
    }

    public String intersection(WordSet other) {
        TreeSet<String> intersectionSet = new TreeSet<>(this.words);
        intersectionSet.retainAll(other.words);
        return String.join(" ", intersectionSet);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
