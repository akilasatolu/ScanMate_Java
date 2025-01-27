import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Investigate {
    public static ArrayList<String> getFiles(String path) {
        return getFiles(path, "");
    }
    public static ArrayList<String> getFiles(String path, String ptn) {
        ArrayList<String> files = new ArrayList<String>();
        getFileList(new File(path).listFiles(), files, Pattern.compile(ptn));
        return files;
    }
    private static void getFileList(File[] fileList, ArrayList<String> files, Pattern p){
        for (File f : fileList) {
            if (f.isDirectory()){
                getFileList(f.listFiles(), files, p);
            } else {
                String strF = f.getPath();
                if(p.matcher(strF).find()){
                    files.add(strF);
                }
            }
        }
    }
    public static ArrayList<String> formatTxt(ArrayList<String> arrX, String rmStr) {
        ArrayList<String> arrY = new ArrayList<String>();
        for (String x : arrX) {
            arrY.add(x.replace(rmStr, ""));
        }
        return arrY;
    }
    public static void grep(ArrayList<String> targetFiles, String[] keywords) {
        
    }
}
