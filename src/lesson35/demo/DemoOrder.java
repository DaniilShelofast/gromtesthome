package lesson35.demo;

import lesson35.controller.OrderController;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.model.UserType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        OrderController orderController = new OrderController();
        String date_s = "10-08-2023 00:00:00";
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = dt.parse(date_s);
        //------------------------------------------------------------------
        String date_s2 = "16-08-2023 00:00:00";
        SimpleDateFormat dt2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date2 = dt2.parse(date_s2);
        //------------------------------------------------------------------
        Hotel hotel = new Hotel(8402174472181398681L, "null", "Ukraine", "Lviv", "Street121");
        User user = new User(3L, "Dima", "123qwe", "Ukraine", UserType.USER);
        Room room = new Room(2934907206750760922L, 1, 100.0, false, true, date, hotel);
        //--------------------------------------------------------------------------
        String date_s3 = "18-01-2016 00:00:00";
        SimpleDateFormat dt3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date3 = dt3.parse(date_s3);
        Hotel hotel1 = new Hotel(4, "Power house", "Ukraine", "Lutsk", "Street143");
        User user1 = new User(8676814712850982767L, "ddd", "fff", "fff", UserType.USER);
        Room room1 = new Room(2359048199224659412L, 2, 200.0, true, true, date3, hotel1);

        // orderController.bookRoom(user.getId(), room.getId(), date, date2);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.AUGUST, 2);
        Date dateFrom = calendar.getTime();
        calendar.set(2023, Calendar.AUGUST, 26);
        Date dateTo = calendar.getTime();
        orderController.bookRoom(user.getId(), room.getId(), dateFrom, dateTo);

    }
}
