package Investigate;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grep {
    public static ArrayList<KeywordData> grep(String path, ArrayList<String> keywords) {
        ArrayList<KeywordData> grepResult = new ArrayList<>();
        ArrayList<String> targetFiles = GetFiles.getFiles(path);
        for (String kw : keywords){
            KeywordData kwd = new KeywordData(kw, false, new ArrayList<>());
            for (String fileName : targetFiles) {
                boolean isFindInFile = false;
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    int lineNum = 0;
                    while ((line = reader.readLine()) != null) {
                        lineNum++;
                        if (line.matches(kw)) {
                            if (!kwd.getIsUsed()) {
                                kwd.setIsUsed(true);
                            }
                            if (!isFindInFile) {
                                isFindInFile = true;
                                UseWhereData useWhereData = new UseWhereData(fileName, new ArrayList<>());
                                kwd.setUseWhereData(useWhereData);
                            }
                            kwd.getUseWhereData().get(kwd.getUseWhereData().size() - 1).setLine(Integer.toString(lineNum));
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
