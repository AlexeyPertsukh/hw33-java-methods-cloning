import java.io.*;
import java.util.Scanner;

public class Util implements Serializable{

    private Util() {
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int nextInt(String text, int min, int max){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(text);
            String cmd = sc.next();

            if(isInteger(cmd)) {
                int num = Integer.parseInt(cmd);
                if(num >= min && num <= max) {
                    return num;
                }
            }
        }
    }

    public static int nextInt(String text, int max){
        return nextInt(text, 0, max);
    }


}
