package lesson35.dao;

import lesson35.exception.DataWritingException;
import lesson35.exception.ObjectConvertingException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class OrderDAO extends GeneralDAO<Order> {

    public final RoomDAO roomDAO = new RoomDAO();
    public final UserDAO userDAO = new UserDAO();

    @Override
    public String getPath() {
        return "C:\\Users\\User\\Desktop//OrderDb.txt";
    }

    public void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo) throws Exception {
        LinkedList<Order> orders = new LinkedList<>();
        for (Order order : readAll()) {
            if (order.getUser().getId() != userId && order.getRoom().getId() != roomId
                    && !order.getDateFrom().equals(dateFrom) && !order.getDateTo().equals(dateTo)) {
                orders.add(order);
            }
        }
        for (Order order : orders) {
            addObjectToFile(order);
        }
    }


    @Override
    public void addObjectToFile(Order order) throws DataWritingException {
        super.addObjectToFile(order);
    }

    @Override
    public LinkedList<Order> readAll() throws Exception {
        return super.readAll();
    }

    @Override
    public Order convert(String string) throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String[] data = string.split(", ");
        if (data.length == 6) {
            Date to = date.parse(data[3]);
            Date from = date.parse(data[4]);
            long idUser = Long.parseLong(data[1]);
            User user = userDAO.findObject(idUser);
            long idRoom = Long.parseLong(data[2]);
            Room room = roomDAO.findObject(idRoom);
            return new Order(Long.parseLong(data[0]), user, room, to, from, Double.parseDouble(data[5]));
        }
        throw new ObjectConvertingException("Database error", new Exception("Error..."));
    }

}
