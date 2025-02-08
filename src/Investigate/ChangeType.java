package Investigate;

import java.util.ArrayList;

class ChangeType {
    static ArrayList<String> toStringList(String[] strArr){
        ArrayList<String> strList = new ArrayList<>();
        for (String str : strArr) {
            strList.add(str);
        }
        return strList;
    }
}