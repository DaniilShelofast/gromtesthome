package lesson35.dao;


import lesson35.model.Hotel;

import java.util.LinkedList;

public class HotelDAO {
    private static final LinkedList<Hotel> hotels = new LinkedList<>();

    public static LinkedList<Hotel> getHotels() {
        return hotels;
    }

    static {
        Hotel hotel1 = new Hotel(1, "Hotel Ukraine", "Ukraine", "Odessa", "street11");
        Hotel hotel2 = new Hotel(2, "Patio di Fiori", "Ukraine", "Lviv", "street167");
        Hotel hotel3 = new Hotel(3, "Rhombus Hotel", "Ukraine", "Lviv", "street121");
        Hotel hotel4 = new Hotel(4, "Power House", "Ukraine", "Lutsk", "street143");
        Hotel hotel5 = new Hotel(5, "Maximus Hotel", "Ukraine", "Kyiv", "street1");
        Hotel hotel6 = new Hotel(6, "Motor Hotel", "Ukraine", "Lutsk", "street74");

    }

   /* public static void readFile() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader())) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can`t write to file with path ");
        }
    }*/

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : getHotels()) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new Exception("Error:");
    }

    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : getHotels()) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new Exception("Error:");
    }

}
