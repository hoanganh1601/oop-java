package ptit.code.vao_ra_file.j07011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + " " + count;
    }
}
