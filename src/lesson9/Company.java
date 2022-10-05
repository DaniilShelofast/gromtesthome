package lesson9;

public class Company {


    private String name;
    private String countryFounder;

    protected String code;

    public int someField;

    public Company(String name, String countryFounder) {
        this.name = name;
        this.countryFounder = countryFounder;
    }

    public String getName() {
        return name;
    }

    public String getCountryFounder() {
        return countryFounder;
    }

    public void setCountryFounder(String countryFounder) {
        this.countryFounder = countryFounder;
    }


}
