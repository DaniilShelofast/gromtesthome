package lesson26.task;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();

        System.out.println(arrayListTest.useList());
    }

    public ArrayList<Order> useList() {
        Order order = new Order(1, 100, "USA", "microcircuit", "ITM");
        ArrayList<Order> list = new ArrayList<>();

        list.add(order);
        System.out.println(list);

        list.add(0, order);
        System.out.println(list);

        list.set(1, order);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.subList(0, 1);
        System.out.println(list);

        list.remove(order);
        System.out.println(list.contains(order));

        Order[] orders = list.toArray(new Order[0]);
        System.out.println(Arrays.deepToString(orders));

        list.clear();
        System.out.println(list);

        Order secondOrder = new Order(12, 200, "USA", "microcircuit", "BMW");
        ArrayList<Order> secondList = new ArrayList<>();
        secondList.add(secondOrder);

        list.addAll(secondList);

        return list;
    }

}
