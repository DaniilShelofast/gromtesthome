package lasson3;

import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
       // List<String> home = new ArrayList<>();
        Scanner str = new Scanner(System.in);
        System.out.println("write words : ");
        String source = str.nextLine();
        String[] world = source.split("");
        StringBuilder recoverSource = new StringBuilder();

        for (int i = 0; i < world.length; i++) {
            char[] letters = world[i].toCharArray();
            for (int j = 0; j < letters.length; j++) {
                System.out.println(letters[j]);

                recoverSource.append(letters[j]);
                System.out.println(recoverSource + " " + "recoverSource");

            }

        }
        // home.add("Hello Friend");
        // System.out.println(home);

        str.close();
    }
}

