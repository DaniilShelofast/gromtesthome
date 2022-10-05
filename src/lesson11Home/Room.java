package lesson11Home;

import java.util.Date;

public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dataAvailableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dataAvailableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dataAvailableFrom = dataAvailableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }

    public Date getDataAvailableFrom() {
        return dataAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDataAvailableFrom(Date dataAvailableFrom) {
        this.dataAvailableFrom = dataAvailableFrom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", persons=" + persons +
                ", dataAvailableFrom=" + dataAvailableFrom +
                ", hotelName='" + hotelName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
