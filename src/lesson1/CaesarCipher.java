package lesson1;

public class CaesarCipher {
    //Метод для шифрування рядка, з допомогою шифру Цезар.
    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder(" ");
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c + shift - 65) % 26 + 65);
                } else {
                    c = (char) ((c + shift - 97) % 26 + 97);
                }
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    //Метод для розшифрування рядка, зашифрованою шифром Цезар.
    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder(" ");
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c - shift - 65 + 26) % 26 + 65);
                } else {
                    c = (char) ((c - shift - 97 + 26) % 26 + 97);
                }
            }
            plaintext.append(c);
        }
        return plaintext.toString();
    }
}
