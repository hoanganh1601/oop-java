package ptit.code.vao_ra_file.j07014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> words;

    public WordSet(String filename) throws FileNotFoundException {
        words = new TreeSet<>();
        Scanner sc = new Scanner(new File(filename));

        while(sc.hasNext()) {
            words.add(sc.next().toLowerCase());
        }
        sc.close();
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
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
