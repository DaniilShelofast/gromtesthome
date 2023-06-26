package lesson35.dao;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.service.RoomService;
import lesson35.service.UserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class OrderDAO extends GeneralDAO<Order> {

    public static void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo) throws Exception {
        LinkedList<Order> orders = new LinkedList<>();
        for (Order order : recordObjectOrder(readFileTextOrder())) {
            if (order.getUser().getId() == userId && order.getRoom().getId() == roomId
                    && order.getDateFrom().equals(dateFrom) && order.getDateTo().equals(dateTo)) {
                orders.add(order);
            }
        }
        for (Order order : orders) {

        }
    }


    public static LinkedList<Order> recordObjectOrder(LinkedList<String> lines) throws Exception {
        UserService userService = new UserService();
        RoomService roomService = new RoomService();
        SimpleDateFormat toDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat fromDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Order> orders = new LinkedList<>();
        for (String line : lines) {
            String[] data = line.split(", ");
            if (data.length == 6) {
                Date to = toDate.parse(data[3]);
                Date from = fromDate.parse(data[4]);
                int idUser = Integer.parseInt(data[1]);
                User user = userService.findIdObject(idUser);
                int idRoom = Integer.parseInt(data[2]);
                Room room = roomService.findIdObject(idRoom);
                orders.add(new Order(Integer.parseInt(data[0]), user, room, to, from, Double.parseDouble(data[5])));
            }
        }
        return orders;
    }


    public static LinkedList<String> readFileTextOrder() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop//OrderDb.txt"))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
