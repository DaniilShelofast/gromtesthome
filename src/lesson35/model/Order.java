package lesson35.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements ModelObject {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    SimpleDateFormat fromData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat toData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    public String toFileString() {
        return this.getId() + ", " + this.getUser().getId() + ", " + this.getRoom().getId() + ", " + fromData.format(getDateFrom()) + ", " + toData.format(getDateTo()) + ", " + this.getMoneyPaid();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", moneyPaid=" + moneyPaid +
                '}';
    }

}
