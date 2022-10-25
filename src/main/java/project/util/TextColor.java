package project.util;

public enum TextColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    PURPLE("\u001B[35m");

    private String ansiCode;
    TextColor(String ansiCode){
        this.ansiCode = ansiCode;
    }

    public void setAnsi_code(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString(){
        return this.ansiCode;
    }
}
