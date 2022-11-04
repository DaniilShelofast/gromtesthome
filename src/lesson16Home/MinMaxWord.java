package lesson16Home;

public class MinMaxWord {
    public static void main(String[] args) {



    }


    public static String maxWord(String input) {
        String[] strings = input.split(" ");
        String max = new String();
        for (int i = 0; i < strings.length; i++) {
            if (max.length() < strings[i].length()) {
                max = strings[i];
            }
        }
        return max;
    }

    public static String minWord(String input) {
        String[] strings = input.split(" ");
        String min = strings[0];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < min.length()) {
                min = strings[i];
            }
        }
        return min;
    }
}








 /* public static boolean validateOne(String address) {
        Pattern pattern = Pattern.compile(".+\\.(com|ua|net)");
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }*/