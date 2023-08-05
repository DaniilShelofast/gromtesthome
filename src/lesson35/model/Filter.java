package lesson35.model;

import java.util.Date;

public class Filter {

    private Integer numberOfGuests;
    private Double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private String country;
    private String city;
    private String hotel;

    public Filter(Integer numberOfGuests, Double price, Boolean breakfastIncluded, Boolean petsAllowed, Date dateAvailableFrom, String country, String city, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.country = country;
        this.city = city;
        this.hotel = hotel.getName();
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public Boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petsAllowed=" + petsAllowed +
                ", dateAvailableFrom=" + dateAvailableFrom +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
