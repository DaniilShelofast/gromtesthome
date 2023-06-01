package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {

        Transaction transaction = new Transaction(12, "Odessa", 40, "money", TransactionType.INCOME, new Date());
        System.out.println(Controller.save(transaction));
    }
}
