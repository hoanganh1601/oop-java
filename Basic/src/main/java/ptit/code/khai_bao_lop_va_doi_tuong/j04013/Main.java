package ptit.code.khai_bao_lop_va_doi_tuong.j04013;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Candidate tmp = new Candidate(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.print(tmp);
    }
}
