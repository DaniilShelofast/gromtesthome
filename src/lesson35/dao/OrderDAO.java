package lesson35.dao;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class OrderDAO extends GeneralDAO<Order> {


    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop//OrderDb.txt";
    }

    /*public void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo) throws Exception {
        LinkedList<Order> orders = new LinkedList<>();
        for (Order order : readAll(readFile())) {
            if (order.getUser().getId() == userId && order.getRoom().getId() == roomId
                    && order.getDateFrom().equals(dateFrom) && order.getDateTo().equals(dateTo)) {
                orders.add(order);
            }
        }
        for (Order order : orders) {
            addObjectToFile(order);
        }
    }*/


    @Override
    public LinkedList<Order> readAll() throws Exception {
        LinkedList<String> strings = readFile();
        UserDAO userDAO = new UserDAO();
        RoomDAO roomDAO = new RoomDAO();
        SimpleDateFormat toDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat fromDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        LinkedList<Order> orders = new LinkedList<>();
        for (String line : strings) {
            String[] data = line.split(", ");
            if (data.length == 6) {
                Date to = toDate.parse(data[3]);
                Date from = fromDate.parse(data[4]);
                int idUser = Integer.parseInt(data[1]);
                User user = userDAO.findIdObject(idUser);
                int idRoom = Integer.parseInt(data[2]);
                Room room = roomDAO.findIdObject(idRoom);
                orders.add(new Order(Integer.parseInt(data[0]), user, room, to, from, Double.parseDouble(data[5])));
            }
        }
        return orders;
    }

    @Override
    public LinkedList<String> readFile() {
        return super.readFile();
    }

    @Override
    public void addObjectToFile(Order order) {
        super.addObjectToFile(order);
    }

}
