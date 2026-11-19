package ptit.classroom.thuc_hanh_02.bai_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int test = sc.nextInt();
        while(test-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int sourceCol = sc.nextInt();

            Matrix mtx = new Matrix(row, col);
            mtx.nextMatrix(sc);
            mtx.sortCol(sourceCol);
            mtx.display();
        }
        sc.close();
    }
}
