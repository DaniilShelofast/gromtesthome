package lesson17Home;


public class Solution {
    public static void main(String[] args) {

        String str = "one two ppp rrr";
       // System.out.println(mostCounterWorld(str));
        System.out.println(countWorlds(str));
    }

    public static String mostCounterWorld(String input) {
        String[] strings = input.split(" ");
        int res[] = new int[strings.length];
        int index = 0;

        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                if (string.equals(strings[i])) {
                    res[i]++;

                }
            }
        }
        for (int j = 0; j < res.length; j++) {
            if (index < res[j]) {
                index = j;
            }

        }
        return strings[index];
    }


    public static int countWorlds(String input) {

        String[] strings = input.split(" ");
        int[] res = new int[strings.length];
        int suma = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    res[i]++;
                    suma += res[i];
                }
            }
        }
        return suma;
    }

}
