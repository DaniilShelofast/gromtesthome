package lesson11Home;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int personPositive = persons + 1;
        int personNegative = persons - 1;
        int sumPerson = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() == price) && (rooms[i].getPersons() >= personNegative && rooms[i].getPersons() <= personPositive) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                sumPerson++;
            }

        }
        Room[] overwritingMassif = new Room[sumPerson];
        int box = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() == price) && (rooms[i].getPersons() >= personNegative && rooms[i].getPersons() <= personPositive) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                overwritingMassif[box] = rooms[i];
                box++;
            }
        }

        return overwritingMassif;
    }


    @Override
    public Room[] getAll() {
        return rooms;
    }

}
