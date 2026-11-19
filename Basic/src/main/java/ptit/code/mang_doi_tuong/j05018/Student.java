package ptit.code.mang_doi_tuong.j05018;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private double averageScore;
    private String rank;

    public Student(int id, String name, double[] scores) {
        this.id = String.format("HS%02d", id);
        this.name = name;
        this.averageScore = calAverage(scores);
        this.rank = Rank(this.averageScore);
    }

    private double calAverage(double[] scores) {
        double total = scores[0] * 2 + scores[1] * 2;
        for (int i = 2; i < scores.length; i++) {
            total += scores[i];
        }
        return Math.round((total / 12.0) * 10.0) / 10.0;
    }

    private String Rank(double avg) {
        if (avg >= 9.0) return "XUAT SAC";
        if (avg >= 8.0) return "GIOI";
        if (avg >= 7.0) return "KHA";
        if (avg >= 5.0) return "TB";
        return "YEU";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", averageScore) + " " + rank;
    }

    @Override
    public int compareTo(Student other) {
        if(Double.compare(other.averageScore, this.averageScore) != 0) {
            return Double.compare(other.averageScore, this.averageScore);
        }
        return this.id.compareTo(other.id);
    }
}
