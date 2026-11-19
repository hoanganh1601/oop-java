package ptit.code.khai_bao_lop_va_doi_tuong.j04005;

public class Candidate {
    private String name;
    private String dob;
    private double score1;
    private double score2;
    private double score3;
    private double totalScore;

    public Candidate(String name, String dob, double score1, double score2, double score3) {
        this.name = name;
        this.dob = dob;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;

        this.totalScore = score1 + score2 + score3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f", name, dob, totalScore);
    }
}
