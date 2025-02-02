package Investigate;

import java.util.ArrayList;

public class UseWhereData {
    private String file;
    private ArrayList<String> line;
    UseWhereData(String file){
        this.file = file;
        this.line = new ArrayList<>();
    }
    UseWhereData(String file, ArrayList<String> line){
        this.file = file;
        this.line = line;
    }
    public String getFile(){
        return file;
    }
    public ArrayList<String> getLine(){
        return line;
    }
    void setLine(String line){
        this.line.add(line);
    }
    public String toString(){
        return "used in " + getFile() + " : " + getLine();
    }
}