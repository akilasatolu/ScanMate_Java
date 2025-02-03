package Investigate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountLine {
    public static int countLine(String path){
        return countLine(path, false);
    }
    public static int countLine(String path, boolean trimBlankFlg){
        int lineCounter = 0;
        ArrayList<String> files = GetFiles.getFiles(path);
        for (String f : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(trimBlankFlg && line.isBlank()){
                        continue;
                    }
                    lineCounter++;
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + f);
                e.printStackTrace();
            }
        }
        return lineCounter;
    }
}
