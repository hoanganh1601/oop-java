package ptit.code.khai_bao_lop_va_doi_tuong.j04012;

import java.util.Scanner;

class Employee {
    private String id;
    private String name;
    private int basicWage;
    private int worksDay;
    private String role;

    public Employee(int id, String name, int basicWage, int worksDay, String role) {
        this.id = String.format("NV%02d", id);
        this.name = name;
        this.basicWage = basicWage;
        this.worksDay = worksDay;
        this.role = role;
    }

    public int getSalary() {
        return basicWage * worksDay;
    }

    public int getBonus() {
        int salary = getSalary();
        if(worksDay >= 25) return (int) (salary * 0.2);
        else if (worksDay >= 22) return (int) (salary * 0.1);
        return 0;
    }

    public int getAllowance() {
        if(role.equals("GD")) return 250000;
        else if(role.equals("PGD")) return 200000;
        else if(role.equals("TP")) return 180000;
        else return 150000;
    }

    public int totalIncome() {
        int res = getSalary() + getBonus() + getAllowance();
        return res;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getSalary() + " " + getBonus() + " " + getAllowance() + " " + totalIncome();
    }
}
