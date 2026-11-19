package ptit.code.khai_bao_lop_va_doi_tuong.j04002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble(), width = sc.nextDouble();
        String color = sc.next();

        if(width > 0 && height > 0) {
            Rectange tmp = new Rectange(height, width, color);
            tmp.normalizeColor();
            System.out.print(tmp);
        }
        else {
            System.out.print("INVALID");
        }
    }
}
