package lesson18Home;


import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {

        //System.out.println(Arrays.toString(findNumbers("1 2 3")));
        System.out.println(Arrays.toString(findNumbers("1 text")));
        System.out.println(Arrays.toString(findNumbers("text")));

    }

    public static int[] findNumbers(String text) {
        String[] texts = text.split(" ");
      //int[] index = new int[texts.length];
        int score = 0;
        for (int j = 0; j < texts.length; j++) {
            try {
                Integer.parseInt(texts[j]);
                score++;
            } catch (Exception ignored) {

            }
        }
        int[] arrayOverwrite = new int[score];
        for (int i = 0; i < texts.length; i++)
            try {
                arrayOverwrite[i] = Integer.parseInt(texts[i]);
            } catch (Exception e) {
                System.err.println("not a number");
            }
        return arrayOverwrite;
    }

}
