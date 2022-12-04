package lesson20.task2;

import lesson20.task2.exception.BadRequestException;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Utils utils = new Utils();
        Controller controller = new Controller();
        Transaction transaction = new Transaction(12, "Odessa", 40, "money", TransactionType.INCOME, new Date());
        controller.save(transaction);
        System.out.println(controller.save(transaction));
        //System.out.println(Arrays.toString(controller.transactionList()));





    }
}
