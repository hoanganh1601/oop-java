package ptit.code.mang_doi_tuong.j05017;

public class Customer implements Comparable<Customer> {
    private String id;
    private String name;
    private long totalCost;

    public Customer(int id, String name, long oldIdx, long newIdx) {
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.totalCost = cal(oldIdx, newIdx);
    }

    private long cal(long oldIdx, long newIdx) {
        long val = newIdx - oldIdx;
        double baseCost = 0;
        double surchargeRate = 0;

        if(val <= 50) {
            baseCost = val * 100;
            surchargeRate = 0.02;
        }
        else if(val <= 100) {
            baseCost = 50 * 100 + (val - 50) * 150;
            surchargeRate = 0.03;
        }
        else {
            baseCost = 50 * 100 + 50 * 150 + (val - 100) * 200;
            surchargeRate = 0.05;
        }

        double res = baseCost * (1.0 + surchargeRate);
        return Math.round(res);
    }

    @Override
    public int compareTo(Customer other) {
        return Long.compare(other.totalCost, this.totalCost);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + totalCost;
    }
}
