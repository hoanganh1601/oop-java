package ptit.classroom.luyen_tap.ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien {
    private String id;
    private String name;
    private String className;
    private String email;
    private String sdt;

    public String getClassName() {
        return className;
    }

    public String getId() {
        return id;
    }

    public SinhVien(String id, String name, String className, String email, String sdt) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + email + " " + sdt;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<SinhVien> list = new ArrayList<>();

        while(sc.hasNextLine()) {
            String id = sc.nextLine().trim();
            if(id.isEmpty()) continue;

            String name = sc.nextLine().trim();
            String className = sc.nextLine().trim();
            String email = sc.nextLine().trim();

            String sdt = "0" + sc.nextLine().trim();
            list.add(new SinhVien(id, name, className, email, sdt));
        }

        Collections.sort(list, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(!o1.getClassName().equals(o2.getClassName())) {
                    return o1.getClassName().compareTo(o2.getClassName());
                }
                return o1.getId().compareTo(o2.getId());
            }
        });

        for (SinhVien sv : list) {
            System.out.println(sv);
        }

        sc.close();
    }
}
