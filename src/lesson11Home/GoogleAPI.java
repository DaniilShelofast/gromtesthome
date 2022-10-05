package lesson11Home;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int check = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() == price) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                check++;
            }
        }

        Room[] overwritingMassif = new Room[check];
        int checkTwo = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i] != null && rooms[i].getPrice() == price) && (rooms[i].getPersons() == persons) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                overwritingMassif[checkTwo] = rooms[i];
                checkTwo++;
            }
        }

        return overwritingMassif;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
