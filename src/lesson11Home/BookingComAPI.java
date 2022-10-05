package lesson11Home;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override

    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int pricePositive = price + 100;
        int priceNegative = price - 100;
        int boxOne = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() >= priceNegative && rooms[i].getPrice() <= pricePositive) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                boxOne++;
            }

        }
        Room[] overwritingMassif = new Room[boxOne];
        int boxTwo = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() >= priceNegative && rooms[i].getPrice() <= pricePositive) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                overwritingMassif[boxTwo] = rooms[i];
                boxTwo++;

            }
        }

        return overwritingMassif;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }
}
