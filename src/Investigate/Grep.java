package Investigate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grep {
    public static ArrayList<KeywordData> grep(String path, String[] keywords) {
        return grep(path, ChangeType.toStringList(keywords));
    }
    public static ArrayList<KeywordData> grep(String path, ArrayList<String> keywords) {
        ArrayList<KeywordData> grepResult = new ArrayList<>();
        ArrayList<String> targetFiles = GetFiles.getFiles(path);
        for (String kw : keywords){
            KeywordData kwd = new KeywordData(kw, false, new ArrayList<>());
            Map<String, UseWhereData> fileMap = new HashMap<>();
            for (String fileName : targetFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    int lineNum = 0;
                    while ((line = reader.readLine()) != null) {
                        lineNum++;
                        if (line.contains(kw)) {
                            if (!kwd.getIsUsed()) {
                                kwd.setIsUsed(true);
                            }
                            UseWhereData useWhereData = fileMap.computeIfAbsent(fileName, key -> new UseWhereData(key, new ArrayList<>()));
                            useWhereData.setLine(Integer.toString(lineNum));
                            if (!kwd.getUseWhereData().contains(useWhereData)) {
                                kwd.setUseWhereData(useWhereData);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + fileName);
                    e.printStackTrace();
                }
            }
            grepResult.add(kwd);
        }
        return grepResult;
    }
}
