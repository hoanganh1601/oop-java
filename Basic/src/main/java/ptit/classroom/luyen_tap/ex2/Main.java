package ptit.classroom.luyen_tap.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien {
    private String name;
    private int correct;
    private int sub;

    public int getCorrect() {
        return correct;
    }

    public String getName() {
        return name;
    }

    public int getSub() {
        return sub;
    }

    public SinhVien(String name, int correct, int sub) {
        this.name = name;
        this.correct = correct;
        this.sub = sub;
    }

    @Override
    public String toString() {
        return name + " " + correct + " " + sub;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));

        int n = sc.nextInt();
        sc.nextLine();
        List<SinhVien> sinhVienList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String name = sc.nextLine();
            int correct = sc.nextInt();
            int sub = sc.nextInt();

            sinhVienList.add(new SinhVien(name, correct, sub));
            if (sc.hasNextLine()) sc.nextLine();
        }

        Collections.sort(sinhVienList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o2.getCorrect() != o1.getCorrect()) {
                    return o2.getCorrect() - o1.getCorrect();
                }
                if(o1.getSub() != o2.getSub()) {
                    return o1.getSub() - o2.getSub();
                }
                return o1.getName().compareTo(o2.getName());
            }
        });


        for (SinhVien sinhVien : sinhVienList) {
            System.out.println(sinhVien);
        }

        sc.close();
    }
}
