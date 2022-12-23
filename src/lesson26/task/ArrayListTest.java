package lesson26.task;


import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        Order order = new Order(1, 100, "USA", "microcircuit", "ITM");
        ArrayListTest arrayListTest = new ArrayListTest();
        System.out.println(arrayListTest.useList(order));
    }

    public Order useList(Order order) {
        ArrayList<Order> list = new ArrayList<>();
        list.add(order);
        list.add(0, order);
        list.set(1, order);
        list.remove(0);
        list.subList(0, 1);
        list.remove(order);
        System.out.println(list.contains(order));
        Order[] orders = list.toArray(new Order[0]);
        list.clear();

        ArrayList<Order> secondList = new ArrayList<>();
        secondList.addAll(0,list);

        return order;
    }

}
