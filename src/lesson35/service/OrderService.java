package lesson35.service;

import lesson35.dao.OrderDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;

import java.util.Date;

import static lesson35.dao.OrderDAO.recordObjectOrder;

public class OrderService {


    private static boolean findRoomByDate(Date dataFrom, Date dateTo) throws Exception {
        OrderDAO dao = new OrderDAO();
        for (Order order : recordObjectOrder(dao.readFileText())) {
            if (!order.getDateFrom().equals(dataFrom) && order.getDateTo().equals(dateTo)) {
                throw new BadRequestException("Error");
            }
        }
        return true;
    }
}
