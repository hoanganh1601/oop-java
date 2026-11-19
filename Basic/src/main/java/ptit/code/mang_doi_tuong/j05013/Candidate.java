package ptit.code.mang_doi_tuong.j05013;

public class Candidate {
    private String id;
    private String name;
    private double theoryScore;
    private double practicalScore;
    private double averageScore;

    public double getAverageScore() {
        return averageScore;
    }

    public Candidate(int id, String name, double theoryScore, double practicalScore) {
        this.id = String.format("TS%02d", id);
        this.name = name;
        this.theoryScore = normalize(theoryScore);
        this.practicalScore = normalize(practicalScore);
        this.averageScore = (this.theoryScore + this.practicalScore) / 2;
    }

    public double normalize(double num) {
        if(num > 10) num /= 10;
        return num;
    }

    public String getStatus() {
        if(averageScore > 9.5) return "XUAT SAC";
        else if(averageScore >= 8) return "DAT";
        else if(averageScore >= 5) return "CAN NHAC";
        else return "TRUOT";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f", this.averageScore) + " " + getStatus();
    }
}
