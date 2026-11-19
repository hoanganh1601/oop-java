package ptit.code.mang_doi_tuong.j05014;

public class Teacher {
    private String id;
    private String name;
    private String subject;
    private double totalScore;
    private String status;

    public double getTotalScore() {
        return totalScore;
    }

    public Teacher(int id, String name, String code, double infoScore, double specScore) {
        this.id = String.format("GV%02d", id);
        this.name = name;
        this.subject = convertSub(code);
        this.totalScore = infoScore * 2 + specScore + priScore(code);
        this.status = convertStatus(totalScore);
    }

    public String convertSub(String code) {
        char tmp = code.charAt(0);
        if(tmp == 'A') return "TOAN";
        else if(tmp == 'B') return "LY";
        else return "HOA";
    }

    public double priScore(String code) {
        char tmp = code.charAt(1);
        if(tmp == '1') return 2.0;
        else if(tmp == '2') return 1.5;
        else if(tmp == '3') return 1.0;
        else return 0.0;
    }

    public String convertStatus(double totalScore){
        if(totalScore >= 18) return "TRUNG TUYEN";
        else return "LOAI";
    }

    @Override
    public String toString(){
        return id + " " + name + " " + subject + " " + String.format("%.1f", totalScore) + " " + status;
    }
}
