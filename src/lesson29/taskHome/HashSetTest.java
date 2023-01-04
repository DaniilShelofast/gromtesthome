package lesson29.taskHome;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

    public static HashSet<Order> useHashSet() {
        HashSet<Order> hashSet = new HashSet<>();
        Order order1 = new Order(11, 100, "EUR", "milk", "lactic");
        Order order2 = new Order(41, 180, "EUR", "cheese", "lactic");
        Order order3 = new Order(52, 150, "EUR", "yogurt", "lactic");
        Order order4 = new Order(5, 50, "EUR", "sourCheese", "lactic");
        Order order5 = new Order(11, 100, "EUR", "lll", "lactic");
        Order order6 = new Order(111, 160, "EUR", "rrr", "lactic");
        Order order7 = new Order(113, 10, "EUR", "hhh", "lactic");

        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);
        hashSet.add(order4);
        hashSet.add(order5);
        hashSet.add(order6);
        hashSet.add(order7);


        hashSet.remove(order2);

        HashSet<Order> orderHashSet = new HashSet<>();
        Order order8 = new Order(54, 80, "EUR", "ooo", "lactic");
        Order order9 = new Order(13, 70, "EUR", "rrr", "lactic");
        Order order10 = new Order(18, 10, "EUR", "jjj", "lactic");
        Order order11 = new Order(88, 710, "EUR", "kkk", "lactic");
        Order order12 = new Order(77, 160, "EUR", "fff", "lactic");

        orderHashSet.add(order1);
        orderHashSet.add(order3);
        orderHashSet.add(order4);
        orderHashSet.add(order8);
        orderHashSet.add(order9);
        orderHashSet.add(order10);

        hashSet.retainAll(orderHashSet);
        hashSet.add(order11);
        hashSet.add(order12);

        Order[] orders =  hashSet.toArray(new Order[0]);
        System.out.println(Arrays.deepToString(orders));
        System.out.println("--");
        System.out.println(hashSet.size());
        System.out.println("--");

        Iterator<Order> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getItemName());
        }
        System.out.println("--");

        hashSet.remove(order11);

        return hashSet;
    }

}
