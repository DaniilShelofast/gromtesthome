package lesson15Home.ApiHome;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int box = 0;
        for (API gap : apis)
            if (gap != null)
                box += gap.findRooms(price, persons, city, hotel).length;

        Room[] checkRoom = new Room[box];
        int boxTwo = 0;
        for (API gap : apis)
            if (gap != null)
                for (int i = 0; i < gap.findRooms(price, persons, city, hotel).length; i++) {
                    checkRoom[box] = gap.findRooms(price, persons, city, hotel)[i];
                    boxTwo++;
                }

        return checkRoom;
    }

    Room cheapestRoom() {
        Room min = null;
        for (int i = 0; i < apis.length; i++) {
            for (int j = 0; j < apis[i].getAll().length; j++) {
                if (min == null || min.getPrice() > apis[i].getAll()[j].getPrice()) {
                    min = apis[i].getAll()[j];
                }
            }
        }


        return min;
    }

    Room[] check(API api1, API api2) {
        int box = 0;
        for (int i = 0; i < api1.getAll().length; i++) {
            if (checkRoom(api2, api1.getAll()[i])) {
                box++;

            }
        }
        Room[] checkTwo = new Room[box];
        int j = 0;
        for (int i = 0; i < api1.getAll().length; i++) {
            if (checkRoom(api2, api1.getAll()[i])) {
                checkTwo[j] = api1.getAll()[i];
                j++;
            }
        }

        return checkTwo;
    }

    private boolean checkRoom(API api, Room room) {
        for (int i = 0; i < api.getAll().length; i++) {

            if ((room.getPrice() == api.getAll()[i].getPrice()) && (room.getPersons() == api.getAll()[i].getPersons()) && (room.getCityName().equals(api.getAll()[i].getCityName())) && (room.getHotelName().equals(api.getAll()[i].getHotelName()))) {
                return true;

            }

        }
        return false;
    }
}



