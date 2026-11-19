package ptit.classroom.chua_phan_nhom.thuchanh3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));

        @SuppressWarnings("unchecked")
        ArrayList<String> list = (ArrayList<String>) ois.readObject();
        ois.close();

        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '0' || c == '1') sb.append(c);
            }

            if(sb.length() > 0) {
                String binary = sb.toString();
                Long dec = Long.parseLong(binary, 2);
                System.out.println(binary + " " + dec);
            }
        }
    }
}
