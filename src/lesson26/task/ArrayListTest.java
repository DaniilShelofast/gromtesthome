package lesson26.task;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {

        System.out.println(useList());
    }

    public static ArrayList<Order> useList() {
        Order order = new Order(1, 100, "USA", "microcircuit", "Opel");
        Order secondOrder = new Order(2, 170, "USA", "microcircuit", "Lada");
        Order thirdOrder = new Order(3, 150, "USA", "microcircuit", "Audi");
        Order fourthOrder = new Order(4, 300, "USA", "microcircuit", "Volvo");
        ArrayList<Order> list = new ArrayList<>();

        list.add(order);
        list.add(1, secondOrder);
        list.add(thirdOrder);
        list.add(fourthOrder);

        list.set(2, order);
        list.remove(1);
        list.subList(0, 2).clear();
        list.remove(order);
        System.out.println(list.contains(fourthOrder));
        Order[] orders = list.toArray(new Order[5]);
        System.out.println(Arrays.deepToString(orders));
        list.clear();

        ArrayList<Order> secondList = new ArrayList<>();
        Order fifthOrder = new Order(5, 170, "USA", "microcircuit", "Mercedes");
        Order sixthOrder = new Order(6, 200, "USA", "microcircuit", "BMW");
        Order seventhOrder = new Order(7, 170, "USA", "microcircuit", "Volvo");
        Order eighthOrder = new Order(8, 70, "USA", "microcircuit", "MercedesGlM");
        Order ninthOrder = new Order(9, 17, "USA", "microcircuit", "Reno");

        secondList.add(fifthOrder);
        secondList.add(sixthOrder);
        secondList.add(seventhOrder);

        list.addAll(secondList);

        list.add(eighthOrder);
        list.add(0, ninthOrder);

        return list;
    }

}
