package Titlovi;

public abstract class Subtitle {
    private String text;
    private int titlNum;

    public Subtitle(String text, int titlNum) {
        this.text = text;
        this.titlNum = titlNum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTitlNum() {
        return titlNum;
    }

    public void setTitlNum(int titlNum) {
        this.titlNum = titlNum;
    }

    public abstract String toString();
}
