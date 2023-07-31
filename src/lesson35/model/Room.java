package lesson35.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Room implements ModelObject {

    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    public String toFileString() {
        return this.getId() + ", " + this.getNumberOfGuests() + ", " + this.getPrice() + ", " + this.isBreakfastIncluded() + ", " + this.isPetsAllowed() + ", " + dateFormat.format(getDateAvailableFrom()) + ", " + this.getHotel().getId();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", hotel=" + hotel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return numberOfGuests == room.numberOfGuests && Double.compare(room.price, price) == 0 && breakfastIncluded == room.breakfastIncluded && petsAllowed == room.petsAllowed && Objects.equals(dateAvailableFrom, room.dateAvailableFrom) && Objects.equals(hotel, room.hotel) && Objects.equals(dateFormat, room.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, hotel, dateFormat);
    }
}
