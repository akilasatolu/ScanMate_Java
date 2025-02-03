import java.util.ArrayList;

import Investigate.UseWhereData;

public class App {
    public static void main(String[] args) {
        // int countLine = Investigate.CountLine.countLine("./test");
        // System.out.println("Total Line is " + countLine);
        ArrayList<String> arrX = Investigate.GetFiles.getFiles("./test");
        // for (String x : arrX) {
        //     System.out.println(x);
        // }
        ArrayList<String> arrY = Investigate.FormatTxt.formatTxt(arrX, "./test/", "");
        // for (String y : arrY) {
        //     System.out.println(y);
        // }
        System.out.println("++++++++++++++++++++++++");
        ArrayList<Investigate.KeywordData> arrZ = Investigate.Grep.grep("./test", arrY);
        for (Investigate.KeywordData z : arrZ) {
            // System.out.println(z.getKeyword());
            // System.out.println(z.getIsUsed());
            // System.out.println(z.getUseWhereData());
            // if(z.getIsUsed()){
            //     for (UseWhereData useWhereData : z.getUseWhereData()) {
            //         System.out.println(useWhereData.getFile());
            //         System.out.println(useWhereData.getLine());
            //     }
            // }
            System.out.println(z);
            System.out.println("++++++++++++++++++++++++");
        }
    }
}
