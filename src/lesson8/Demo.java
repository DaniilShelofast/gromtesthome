package lesson8;

import lesson8.phones.IPhone;

public class Demo {
    public static void main(String[] args) {
      /*  Adder adder = new Adder();
        int[] array = {1, 2, 4, 5, 6, 7, 8, 11};
        adder.check(array);
        adder.add(1, 2);*/

        //----------------------------------------------------------
        IPhone iPhone = new IPhone(110, 10.0, "China", true);
        iPhone.deleteIPhoneFromOb();
        iPhone.orderPhone();


    }
}
