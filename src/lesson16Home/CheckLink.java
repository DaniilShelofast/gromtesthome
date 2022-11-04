package lesson16Home;

public class CheckLink {
    public static void main(String[] args) {

        System.out.println(validate("ftp://abc.net"));
        System.out.println(validate("http://aa.abc.com"));
        System.out.println(validate("https://abc.ua"));
        System.out.println(validate("https://www.abc.ua"));
        System.out.println(validate("http://abc.com"));
        System.out.println(validate("https://abc.com"));
        System.out.println(validate("https://www.abc.net"));

    }


    public static boolean validate(String address) {


        String[] end = {"com", "net", "org"};
        String[] beginning = {"https://", "http://", "https://www.", "http://www."};

        for (int i = 0; i < beginning.length; i++) {
            if (address.startsWith(beginning[i])) {
                String stringBeginning = address.replace(beginning[i], "");

                for (int k = 0; k < end.length; k++) {
                    if (address.endsWith(end[k])) {
                        String stringEnd = address.replace(end[k], "");

                        return !checkSymbol(stringEnd);

                    }

                }
            }
        }
        return false;
    }

    private static boolean checkSymbol(String string) {
        char[] ch = string.toCharArray();
        for (int j = 0; j < ch.length; j++) {

            if (!Character.isLetterOrDigit(ch[j])) {
                return false;
            }
        }
        return true;
    }
}
