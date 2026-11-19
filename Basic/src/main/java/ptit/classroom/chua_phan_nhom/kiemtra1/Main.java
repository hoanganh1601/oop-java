package ptit.classroom.chua_phan_nhom.kiemtra1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Pair<Integer, Integer>> edges = new ArrayList<>();

        int n = Integer.parseInt(line);
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; ++j) {
                int val = Integer.parseInt(st.nextToken());
                if(j > i && val == 1) edges.add(new Pair<>(i, j));
            }
        }

        for (Pair<Integer, Integer> p : edges) System.out.println(p);
    }
}
