package ptit.code.khai_bao_lop_va_doi_tuong.j04017;

import java.util.Scanner;

class Matrix {
    private int row;
    private int col;
    private int[][] data;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new int[row][col];
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                data[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix trans() {
        Matrix res = new Matrix(col, row);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res.data[j][i] = this.data[i][j];
            }
        }

        return res;
    }

    public Matrix mul(Matrix p) {
        Matrix res = new Matrix(this.row, p.col);
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < p.col; ++j) {
                res.data[i][j] = 0;
                for (int k = 0; k < this.col; ++k) {
                    res.data[i][j] += this.data[i][k] * p.data[k][j];
                }
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
