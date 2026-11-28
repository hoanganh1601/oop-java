package ptit.code.vao_ra_file.j07024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.IOException;

class WordSet {
    private TreeSet<String> words;

    public WordSet(String fileName) throws FileNotFoundException {
        words = new TreeSet<>();
        Scanner sc = new Scanner(new File(fileName));

        while(sc.hasNext()) {
            words.add(sc.next().toLowerCase());
        }
        sc.close();
    }

    public String difference(WordSet other) {
        TreeSet<String> res = new TreeSet<>(this.words);
        res.removeAll(other.words);
        return String.join(" ", res);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
