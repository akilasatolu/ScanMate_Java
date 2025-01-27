import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> arrX = Investigate.getFiles("./test/");
        ArrayList<String> arrY = Investigate.formatTxt(arrX, "./");
        for (String y : arrY) {
            System.out.println(y);
        }
    }
}
