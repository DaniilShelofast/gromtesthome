package lesson6;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Deal lesson = new Deal(100, new Date(), true, new Date(1658007696000l), "Mexico"," Ukraine","Sale" );
        /*lesson.confirmOrder();
        System.out.println(lesson.isConfirmed);
        System.out.println(lesson.dataConfirmed);*/

       /* boolean res =lesson.checkPrice();
        System.out.println(res);*/

        boolean res = lesson.isValidType();
        System.out.println(res);

    }
}
