package ptit.code.mang_doi_tuong.j05009;


public class Candidate {
    private int id;
    private String name;
    private String dob;
    private double m1;
    private double m2;
    private double m3;


    public Candidate(int id, String name, String dob, double m1, double m2, double m3){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public double getTotalScore() {
        return m1 + m2 + m3;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + dob + " " + getTotalScore();
    }
}
