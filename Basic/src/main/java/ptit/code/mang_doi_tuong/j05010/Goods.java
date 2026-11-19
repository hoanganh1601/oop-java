package ptit.code.mang_doi_tuong.j05010;

import java.util.*;

class Goods {
    private int id;
    private String name;
    private String productCategory;
    private double purchasePrice;
    private double salePrice;

    public Goods(int id, String name, String productCategory, double purchasePrice, double salePrice) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
    }

    public double getProfit() {
        return salePrice - purchasePrice;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + productCategory + " " + String.format("%.2f", getProfit());
    }
}
