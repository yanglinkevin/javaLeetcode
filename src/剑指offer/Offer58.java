package 剑指offer;

public class Offer58 {
    public static void main(String[] args) {
        Offer58 test = new Offer58();
        String s = "  hello world!  ";
        String result = test.reverseWords(s);
        System.out.println(result);
    }
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=strings.length-1; i>=0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            if (i==0){
                stringBuffer.append(strings[i].trim());
            } else {
                stringBuffer.append(strings[i].trim()).append(" ");
            }
        }
        return stringBuffer.toString();
    }
}
