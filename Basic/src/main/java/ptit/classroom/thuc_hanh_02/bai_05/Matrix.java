package ptit.classroom.thuc_hanh_02.bai_05;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int row, col;
    private int[][] arr;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.arr = new int[row][col];
    }

    public void nextMatrix(Scanner sc) {
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                this.arr[r][c] = sc.nextInt();
            }
        }
    }

    // sort cot col
    public void sortCol(int col) {
        int c = col - 1;
        int[] tmp = new int[row];
        for (int r = 0; r < row; ++r) {
            tmp[r] = this.arr[r][c];
        }

        Arrays.sort(tmp);

        for (int r = 0; r < row; ++r) {
            this.arr[r][c] = tmp[r];
        }
    }

    public void display() {
        for (int r = 0 ; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
    }
}
