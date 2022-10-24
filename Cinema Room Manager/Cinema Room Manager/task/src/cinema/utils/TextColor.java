package cinema.utils;

public enum TextColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    PURPLE("\u001B[35m");

    private String ansiCode;
    private TextColor(String ansiCode){
        this.ansiCode = ansiCode;
    }

    public void setAnsi_code(java.lang.String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString(){
        return this.ansiCode;
    }
}
