package 剑指offer;

public class Offer59 {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);

    }
}
