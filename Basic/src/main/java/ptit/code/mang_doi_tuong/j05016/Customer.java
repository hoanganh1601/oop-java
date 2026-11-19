package ptit.code.mang_doi_tuong.j05016;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Comparable<Customer> {
    private String id;
    private String name;
    private String room;
    private long daysStayed;
    private long totalCost;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Customer(int id, String name, String room, String checkIn, String checkOut, long extraFee) throws ParseException {
        this.id = String.format("KH%02d", id);
        this.name = name.trim();
        this.room = room.trim();

        Date checkInDate = sdf.parse(checkIn);
        Date checkOutDate = sdf.parse(checkOut);

        calBilling(checkInDate, checkOutDate, extraFee);
    }

    public void calBilling(Date checkInDate, Date checkOutDate, long extraFee) {
        long diffMili = checkOutDate.getTime() - checkInDate.getTime();
        long diffDays = diffMili / (1000 * 60 * 60 * 24);

        this.daysStayed = diffDays + 1;
        long roomPrice = getPrice(this.room);

        this.totalCost = roomPrice * this.daysStayed + extraFee;
    }

    public long getPrice(String room) {
        char floor = room.charAt(0);
        if(floor == '1') return 25;
        else if(floor == '2') return 34;
        else if(floor == '3') return 50;
        return 80;
    }

    @Override
    public int compareTo(Customer other) {
        return Long.compare(other.totalCost, this.totalCost);
    }

    @Override
    public String toString() {
        return id + " " +  name + " " + room + " " + daysStayed + " " + totalCost;
    }
}
