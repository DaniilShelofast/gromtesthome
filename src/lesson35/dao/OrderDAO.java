package lesson35.dao;

import lesson35.model.Order;

import java.util.LinkedList;

public class OrderDAO {

    private static final LinkedList<Order> orders = new LinkedList<>();

    public static LinkedList<Order> getHotels() {
        return orders;
    }
}
