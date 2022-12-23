package lesson26.task;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        System.out.println(arrayListTest.useList());
    }

    public ArrayList<Order> useList() {
        Order order = new Order(1, 100, "USA", "microcircuit", "GGG");
        Order eighthOrder = new Order(8, 150, "USA", "microcircuit", "AudiQ8");
        Order ninthOrder = new Order(9, 300, "USA", "microcircuit", "Reno");
        Order seventhOrder = new Order(7, 170, "USA", "microcircuit", "MercedesGlM");
        ArrayList<Order> list = new ArrayList<>();

        list.add(order);
        list.add(eighthOrder);
        list.add(seventhOrder);
        list.add(ninthOrder);


        list.add(1, seventhOrder);
        System.out.println(list);

        list.set(1, order);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);


        list.subList(0, 1);
        System.out.println(list);

        list.remove(order);
        System.out.println(list.contains(ninthOrder));

        Order[] orders = list.toArray(new Order[4]);
        System.out.println(Arrays.deepToString(orders));

        list.clear();
        System.out.println(list);

        Order secondOrder = new Order(2, 170, "USA", "microcircuit", "Lada");
        Order thirdOrder = new Order(3, 150, "USA", "microcircuit", "Audi");
        Order fourthOrder = new Order(4, 300, "USA", "microcircuit", "Volvo");
        Order fifthOrder = new Order(5, 170, "USA", "microcircuit", "Mercedes");
        Order sixthOrder = new Order(6, 200, "USA", "microcircuit", "BMW");
        ArrayList<Order> secondList = new ArrayList<>();
        secondList.add(sixthOrder);
        secondList.add(secondOrder);
        secondList.add(thirdOrder);
        secondList.add(fourthOrder);
        secondList.add(fifthOrder);

        list.addAll(secondList);


        return list;
    }

}
