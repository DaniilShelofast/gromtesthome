package lesson6;

public class Car {

    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

    void startRun() {
        System.out.println(" I am running.....");
    }

    void stopRun() {
    System.out.println("I am stopping....");
    }

    void changerOwner(String newOwnerNane){
        ownerName = newOwnerNane;
    }
}
