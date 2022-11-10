package lesson18;

public class Test {
    public static void main(String[] args) {


        String data = null;

        try{
            System.out.println(1);
            data.toString();
            System.out.println(2);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("catch 1");
        }catch (NullPointerException ee){
            System.out.println("catch 2" + ee.getMessage());
        }catch (Exception exception){
            System.out.println("catch 3" + exception.getMessage());
        }finally {
            System.out.println("finally");
        }
        System.out.println("ok");
    }
}
