package ptit.classroom.chua_phan_nhom.thuchanh13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Subject implements Comparable<Subject> {
    private String id;
    private String name;
    private String hinhThuc;

    public Subject(String id, String name, String hinhThuc) {
        this.id = id;
        this.name = name;
        this.hinhThuc = hinhThuc;
    }

    @Override
    public int compareTo(Subject other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + hinhThuc;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        List<Subject> subjectList = new ArrayList<>();
        Set<String> se = new HashSet<>();

        while(sc.hasNextLine()) {
            String id = sc.nextLine().trim();

            if(id.isEmpty()) continue;
            String name = sc.nextLine().trim();
            String hinhThuc = sc.nextLine().trim();

            if(!se.contains(id)) {
                se.add(id);
                subjectList.add(new Subject(id, name, hinhThuc));
            }
        }

        Collections.sort(subjectList);

        for (Subject sb : subjectList) {
            System.out.println(sb);
        }

        sc.close();
    }
}
