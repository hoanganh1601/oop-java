package ptit.code.vao_ra_file.j07022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        List<String> arr = new ArrayList<>();

        while(sc.hasNext()) {
            if(sc.hasNextInt()) {
                sc.nextInt();
            }
            else {
                arr.add(sc.next());
            }
        }
        Collections.sort(arr);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        sc.close();
    }
}
