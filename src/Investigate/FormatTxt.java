package Investigate;

import java.util.ArrayList;

public class FormatTxt {
    public static ArrayList<String> formatTxt(ArrayList<String> arrX, String before, String after) {
        if(arrX == null || before == null || after == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        ArrayList<String> arrY = new ArrayList<>();
        for (String x : arrX) {
            arrY.add(x.replace(before, after));
        }
        return arrY;
    }
}
