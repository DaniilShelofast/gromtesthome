package lesson35.service;

import lesson35.dao.OrderDAO;
import lesson35.dao.RoomDAO;
import lesson35.dao.UserDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OrderService {

    private final OrderDAO orderDAO = new OrderDAO();
    public final RoomDAO roomDAO = new RoomDAO();
    public final UserDAO userDAO = new UserDAO();

    public void bookRoom(long userId, long roomId, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomDAO.findObject(roomId);
        User user = userDAO.findObject(userId);
        isRoomAvailable(room.getId(), dateFrom, dateTo);
        double totalPrice = calculateTotalPrice(room.getPrice(), dateFrom, dateTo);
        orderDAO.addObjectToFile(new Order(user, room, dateFrom, dateTo, totalPrice));
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

    private double calculateTotalPrice(double roomPrice, Date dateFrom, Date dateTo) throws BadRequestException {
        return roomPrice * getNumberOfNights(dateFrom, dateTo);
    }

    private boolean isRoomAvailable(long roomId, Date dateFrom, Date dateTo) throws Exception {
        validateDate(dateFrom, dateTo);
        for (Order order : orderDAO.readAll()) {
            if (order.getRoom().getId() == roomId && dateFrom.before(order.getDateTo()) && dateTo.after(order.getDateFrom())) {
                throw new BadRequestException("Error : hotel number and these date numbers are busy.");
            }
        }
        return true;
    }

    private long getNumberOfNights(Date dateFrom, Date dateTo) throws BadRequestException {
        Date today = new Date();
        if (dateFrom.getTime() >= dateTo.getTime() || today.getTime() > dateTo.getTime() || today.getTime() >= dateFrom.getTime()) {
            throw new BadRequestException("Error : the arrival date is greater than the departure date.");
        }
        long timeIndex = dateTo.getTime() - dateFrom.getTime();
        return TimeUnit.DAYS.convert(timeIndex, TimeUnit.MILLISECONDS);
    }

    private void validateDate(Date dateFrom, Date dateTo) throws BadRequestException {
        if (dateFrom == null || dateTo == null) {
            throw new BadRequestException("Error : date parameter can not be Null.");
        }
    }


}
