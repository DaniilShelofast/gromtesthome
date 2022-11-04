package lesson11Home;

public class Controller {

    API[] apis;

    public Controller(API[] apis) {

        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int suma = 0;
        for (API value : apis) {
            if (value != null) {
                suma += value.findRooms(price, persons, city, hotel).length;
            }
        }

        Room[] room = new Room[suma];
        int box = 0;

        for (API api : apis) {
            if (api != null)
                for (int j = 0; j < api.findRooms(price, persons, city, hotel).length; j++) {
                    room[box] = api.findRooms(price, persons, city, hotel)[j];
                    box++;
                }

        }
        return room;
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

    private boolean checkRoom(API api, Room room) {
        for (int i = 0; i < api.getAll().length; i++) {

            if ((room.getPrice() == api.getAll()[i].getPrice()) && (room.getPersons() == api.getAll()[i].getPersons()) && (room.getCityName() == api.getAll()[i].getCityName()) && (room.getHotelName() == api.getAll()[i].getHotelName())) {
                return true;

            }

        }
        return false;
    }

}



