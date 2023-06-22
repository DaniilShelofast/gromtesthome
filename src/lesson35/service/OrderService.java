package lesson35.service;

import lesson35.exception.BadRequestException;
import lesson35.model.Order;

import java.util.Date;

import static lesson35.dao.OrderDAO.readFileTextOrder;
import static lesson35.dao.OrderDAO.recordObjectOrder;

public class OrderService {


    public static boolean findRoomByDate(Date dataFrom, Date dateTo) throws Exception {
        for (Order order : recordObjectOrder(readFileTextOrder())) {
            if (!order.getDateFrom().equals(dataFrom) && order.getDateTo().equals(dateTo)) {
                throw new BadRequestException("Error");
            }
        }
        return true;
    }
}
