package lesson35.service;

import lesson35.dao.OrderDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Order;

import java.util.Date;



public class OrderService {


    private static boolean findRoomByDate(Date dataFrom, Date dateTo) throws Exception {
        OrderDAO dao = new OrderDAO();
        for (Order order : dao.recordObject(dao.readFileText())) {
            if (!order.getDateFrom().equals(dataFrom) && order.getDateTo().equals(dateTo)) {
                throw new BadRequestException("Error");
            }
        }
        return true;
    }
}
