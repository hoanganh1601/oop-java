package ptit.code.vao_ra_file.j07002;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long sum = 0;
        try {
            Scanner sc = new Scanner(new File("DATA.in"));

            while(sc.hasNext()) {
                String tmp = sc.next();
                try{
                    int val = Integer.parseInt(tmp);
                    sum += val;
                } catch (NumberFormatException e) {

                }
            }

            System.out.print(sum);
            sc.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
