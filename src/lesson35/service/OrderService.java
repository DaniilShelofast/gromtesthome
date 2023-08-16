package lesson35.service;

import lesson35.dao.OrderDAO;
import lesson35.dao.RoomDAO;
import lesson35.dao.UserDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.util.Date;

import static lesson35.service.DateUtils.getNumberOfNights;

public class OrderService {

    private final OrderDAO orderDAO = new OrderDAO();
    public final RoomDAO roomDAO = new RoomDAO();
    public final UserDAO userDAO = new UserDAO();

    public void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo) throws Exception {
        isRoomAvailable(roomId, dateFrom, dateTo);

        Room room = roomDAO.findObject(roomId);
        User user = userDAO.findObject(userId);

        double totalPrice = calculateTotalPrice(room, dateFrom, dateTo);
        Order order = new Order(user, room, dateFrom, dateTo, totalPrice);
        orderDAO.addObjectToFile(order);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        Room room = roomDAO.findObject(roomId);
        User user = userDAO.findObject(userId);

        for (Order o : orderDAO.readAll()) {
            if (o.getUser().getId() == user.getId() && o.getRoom().getId() == room.getId()) {
                orderDAO.deleteObjectFromFile(o.getId());
            }
        }
    }

    private double calculateTotalPrice(Room room, Date dateFrom, Date dateTo) throws BadRequestException {
        return room.getPrice() * getNumberOfNights(dateFrom, dateTo);
    }

    private boolean isRoomAvailable(long roomId, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomDAO.findObject(roomId);
        if (dateFrom == null || dateTo == null) {
            throw new BadRequestException("Error : date parameter can not be Null.");
        }

        for (Order order : orderDAO.readAll()) {
            if (order.getRoom().getId() == room.getId() && dateFrom.before(order.getDateTo()) && dateTo.after(order.getDateFrom())) {
                throw new BadRequestException("Error : hotel number and these date numbers are busy.");
            }
        }
        return true;
    }

}
