package Investigate;

import java.util.ArrayList;

public class KeywordData {
    private String keyword;
    private boolean isUsed;
    private ArrayList<UseWhereData> useWhereData;
    KeywordData(String keyword, boolean isUsed, ArrayList<UseWhereData> useWhereData) {
        this.keyword = keyword;
        this.isUsed = isUsed;
        this.useWhereData = (useWhereData != null) ? useWhereData : new ArrayList<>();
    }
    public String getKeyword(){
        return keyword;
    }
    public boolean getIsUsed(){
        return isUsed;
    }
    void setIsUsed(boolean isUsed){
        this.isUsed = isUsed;
    }
    public ArrayList<UseWhereData> getUseWhereData(){
        return useWhereData;
    }
    void setUseWhereData(UseWhereData useWhereData){
        if(useWhereData != null){
            this.useWhereData.add(useWhereData);
        }
    }
    public String toString(){
        String useWhereStrings = "";
        for (int i = 0; i < getUseWhereData().size(); i++) {
            useWhereStrings += ("\n" + getUseWhereData().get(i).toString());
        }
        return getKeyword() +"\n"+ getIsUsed() + useWhereStrings;
    }
}