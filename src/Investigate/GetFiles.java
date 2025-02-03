package Investigate;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class GetFiles {
    public static ArrayList<String> getFiles(String path) {
        return getFiles(path, null);
    }
    public static ArrayList<String> getFiles(String path, String regex) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + path);
        }
        Pattern pattern = (regex == null || regex.isEmpty()) ? null : Pattern.compile(regex);
        return FormatTxt.formatTxt(getFileList(dir.listFiles(), pattern), "\\", "/");
    }
    private static ArrayList<String> getFileList(File[] fileList, Pattern p){
        ArrayList<String> files = new ArrayList<>();
        if(fileList == null){
            return files;
        }
        for (File f : fileList) {
            if (f.isDirectory()){
                files.addAll(getFileList(f.listFiles(), p));
            } else {
                String fPath = f.getPath();
                if(p == null || p.matcher(fPath).find()){
                    files.add(fPath);
                }
            }
        }
        return files;
    }   
}