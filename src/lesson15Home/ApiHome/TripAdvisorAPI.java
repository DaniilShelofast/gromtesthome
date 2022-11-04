package lesson15Home.ApiHome;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int box = 0;

        int personPositive = persons + 1;
        int personNegative = persons - 1;
        for (int j = 0; j < rooms.length; j++) {
            if ((rooms[j] != null && rooms[j].getPrice() == price) && (personNegative <= rooms[j].getPersons()) && (rooms[j].getPersons() <= personPositive) && (rooms[j].getCityName().equals(city)) && (rooms[j].getHotelName().equals(hotel))) {
                box++;
            }


        }
        Room[] checkRoom = new Room[box];
        int boxBig = 0;

        for (int j = 0; j < rooms.length; j++) {
            if ((rooms[j] != null && rooms[j].getPrice() == price) && (personNegative <= rooms[j].getPersons()) && (rooms[j].getPersons() <= personPositive) && (rooms[j].getCityName().equals(city)) && (rooms[j].getHotelName().equals(hotel))) {
                checkRoom[box] = rooms[j];
                boxBig++;
            }
        }

        return checkRoom;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
