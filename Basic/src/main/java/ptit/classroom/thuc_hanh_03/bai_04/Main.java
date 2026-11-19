package ptit.classroom.thuc_hanh_03.bai_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Truong {
    private String maTruong;
    private String tenTruong;

    public Truong(String maTruong, String tenTruong) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }
}

class Doi implements Comparable<Doi>{

    private String id;
    private String tenDoi;
    private Truong truong;

    public Doi(String tenDoi, Truong truong) {
        this.tenDoi = tenDoi;
        this.truong = truong;
    }

    public void setId(int id) {
        this.id = String.format("team%02d", id);
    }

    public String getTenDoi() {
        return tenDoi;
    }

    public Truong getTruong() {
        return truong;
    }

    @Override
    public int compareTo(Doi other) {
        if(!this.truong.getTenTruong().equals(other.truong.getTenTruong())) {
            return this.truong.getTenTruong().compareTo(other.truong.getTenTruong());
        }
        return this.tenDoi.compareTo(other.tenDoi);
    }

    @Override
    public String toString() {
        return id + " " + tenDoi + " " + truong.getTenTruong();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("INSTITUTION.in"));

        int num1 = Integer.parseInt(sc1.nextLine());
        Map<String, Truong> mpTruong = new HashMap<>();

        for (int i = 0; i < num1; ++i) {
            String line = sc1.nextLine();
            int spaceIdx = line.indexOf(" ");
            String id = line.substring(0, spaceIdx);
            String name = line.substring(spaceIdx + 1);
            mpTruong.put(id, new Truong(id, name));
        }
        sc1.close();

        Scanner sc2 = new Scanner(new File("REGISTER.in"));
        int num2 = Integer.parseInt(sc2.nextLine());
        List<Doi> dsDoi = new ArrayList<>();

        for (int i = 0; i < num2; ++i) {
            String first = sc2.nextLine();
            while(first.isEmpty() && sc2.hasNextLine()) {
                first = sc2.nextLine();
            }

            String[] token = first.split("\\s+");
            String maTruong = token[0];
            int soDoi = Integer.parseInt(token[1]);

            Truong truong = mpTruong.get(maTruong);
            for (int j = 0; j < soDoi; ++j) {
                String tenDoi = sc2.nextLine();
                dsDoi.add(new Doi(tenDoi, truong));
            }
        }
        sc2.close();

        Collections.sort(dsDoi);

        for (int i = 0; i < dsDoi.size(); ++i) {
            dsDoi.get(i).setId(i + 1);
            System.out.println(dsDoi.get(i));
        }
    }
}
