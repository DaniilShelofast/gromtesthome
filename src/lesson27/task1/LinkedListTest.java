package lesson27.task1;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println(useList());

    }

    public static LinkedList<Order> useList() {
        Order oneOrder = new Order(1, 100, "EUR", "microcircuit", "Opel");
        Order secondOrder = new Order(2, 170, "EUR", "microcircuit", "Lada");
        Order thirdOrder = new Order(3, 150, "EUR", "microcircuit", "Audi");
        Order fourthOrder = new Order(4, 300, "EUR", "microcircuit", "Volvo");
        LinkedList<Order> linkedList = new LinkedList<>();

        linkedList.add(oneOrder);

        linkedList.clear();

        linkedList.add(secondOrder);
        linkedList.add(0, thirdOrder);
        linkedList.add(fourthOrder);

        linkedList.remove(thirdOrder);
        linkedList.remove(1);

        Order fifthOrder = new Order(5, 170, "USA", "microcircuit", "Mercedes");
        Order sixthOrder = new Order(6, 200, "USA", "microcircuit", "BMW");
        Order seventhOrder = new Order(7, 170, "USA", "microcircuit", "Volvo");
        Order eighthOrder = new Order(8, 70, "USA", "microcircuit", "MercedesGlM");
        Order ninthOrder = new Order(9, 17, "USA", "microcircuit", "Reno");
        LinkedList<Order> list = new LinkedList<>();

        linkedList.addAll(list);
        linkedList.add(fifthOrder);
        linkedList.add(sixthOrder);
        linkedList.add(seventhOrder);

        linkedList.subList(0, 1).clear();

        linkedList.set(0, seventhOrder);
        linkedList.add(eighthOrder);
        linkedList.add(0, ninthOrder);
        System.out.println(linkedList.contains(ninthOrder));

        Order[] orders = linkedList.toArray(new Order[10]);
        System.out.println(Arrays.deepToString(orders));


        return linkedList;
    }
}
