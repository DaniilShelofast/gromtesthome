package lesson10Home;

public class Customer {

    public String name;
    public String city;
    public String gender;

    public Customer(String name, String city, String gender) {
        this.name = name;
        this.city = city;
        this.gender = gender;
    }

  /*  public Customer(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwner, String name, String city, String gender) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwner);
        this.name = name;
        this.city = city;
        this.gender = gender;
    }*/


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }


}
