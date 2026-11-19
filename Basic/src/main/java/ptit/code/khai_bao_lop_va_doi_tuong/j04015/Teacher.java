package ptit.code.khai_bao_lop_va_doi_tuong.j04015;

public class Teacher {
    private String id;
    private String name;
    private int basicSalary;

    public Teacher(String id, String name, int basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getGradeCoefficient() {
        String suffix = id.substring(2);
        return Integer.parseInt(suffix);
    }

    public String getRole() {
        return id.substring(0, 2);
    }

    public int getAllowance() {
        String prefix = getRole();
        if(prefix.equals("HT")) return 2000000;
        else if(prefix.equals("HP")) return 900000;
        else return 500000;
    }

    public int getTotalIncome() {
        return basicSalary * getGradeCoefficient() + getAllowance();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getGradeCoefficient() + " " + getAllowance() + " " + getTotalIncome();
    }
}
