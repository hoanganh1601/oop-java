package ptit.code.mang_doi_tuong.j05012;

public class Goods {
    private String id;
    private String name;
    private long quantity;
    private long price;
    private long discount;
    private long totalAmount;

    public long getTotalAmount() {
        return totalAmount;
    }

    public Goods(String id, String name, long quantity, long price, long discount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;

        this.totalAmount = (this.price * this.quantity) - this.discount;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + quantity + " " + price + " " + discount + " " + totalAmount;
    }
}
