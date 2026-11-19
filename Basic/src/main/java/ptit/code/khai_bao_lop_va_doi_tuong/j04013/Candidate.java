package ptit.code.khai_bao_lop_va_doi_tuong.j04013;

public class Candidate {
    private String id;
    private String name;
    private double maths;
    private double physic;
    private double chemistry;

    public Candidate(String id, String name, double maths, double physic, double chemistry) {
        this.id = id;
        this.name = name;
        this.maths = maths;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public double getPriorityPoint() {
        String prefix = id.substring(0, 3);
        if(prefix.equals("KV1")) return 0.5;
        else if(prefix.equals("KV2")) return 1.0;
        else return 2.5;
    }

    public double getTotalScore(){
        return maths * 2 + physic + chemistry;
    }

    public String getStatus() {
        double res = getTotalScore() + getPriorityPoint();
        if(res >= 24) return "TRUNG TUYEN";
        else return "TRUOT";
    }

    public String formatNumber(double val) {
        if(val == (int)val) {
            return String.format("%d", (int)val);
        }
        else {
            return String.format("%.1f", val);
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + formatNumber(getPriorityPoint()) + " " + formatNumber(getTotalScore()) + " " + getStatus();
    }
}
