package lesson15Home.ApiHome;


public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int box = 0;
        int pricePositive = price + 100;
        int priceNegative = price - 100;
        for (int i = 0; i < rooms.length; i++) {

            if ((rooms[i] != null && rooms[i].getPrice() >= priceNegative && rooms[i].getPrice() <= pricePositive) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName().equals(city) && (rooms[i].getHotelName().equals(hotel)))) {
                box++;
            }
        }
        Room[] checkRoom = new Room[box];
        int boxTwo = 0;

        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() >= priceNegative && rooms[i].getPrice() <= pricePositive) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName().equals(city) && (rooms[i].getHotelName().equals(hotel)))) {
                checkRoom[boxTwo] = rooms[i];
                boxTwo++;
            }

        }
        return checkRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}