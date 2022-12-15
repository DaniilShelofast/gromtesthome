package lesson24;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> sysDAO = new GeneralDAO<>();
        Sys sys = new Sys(11, "gps");
        sysDAO.save(sys);
        System.out.println(Arrays.deepToString(sysDAO.getAll()));
        sysDAO.save(sys);
        System.out.println(Arrays.deepToString(sysDAO.getAll()));

        System.out.println(" ");

        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();
        Tool tool = new Tool("php", "good");
        toolDAO.save(tool);
        System.out.println(Arrays.deepToString(toolDAO.getAll()));

        System.out.println(" ");

        GeneralDAO<Order> orderDAO = new GeneralDAO<>();
        Order order = new Order("done", "Odessa");
        orderDAO.save(order);
        System.out.println(Arrays.deepToString(orderDAO.getAll()));
    }
}
