package ptit.classroom.chua_phan_nhom.thuchanh11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    private int rows;
    private int cols;
    private int[][] d;

    public Matrix(int rows, int cols, Scanner sc) {
        this.rows = rows;
        this.cols = cols;
        this.d = new int[rows][cols];
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                this.d[r][c] = sc.nextInt();
            }
        }
    }

    public void sortColumn(int colIdx) {
        int tmp = colIdx - 1;
        int[] colD = new int[rows];

        for (int r = 0; r < rows; ++r) {
            colD[r] = d[r][tmp];
        }

        Arrays.sort(colD);

        for (int r = 0; r < rows; ++r) {
            d[r][tmp] = colD[r];
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                sb.append(d[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int i = sc.nextInt();

            Matrix matrix = new Matrix(n, m, sc);
            matrix.sortColumn(i);
            matrix.print();
        }

        sc.close();
    }
}
