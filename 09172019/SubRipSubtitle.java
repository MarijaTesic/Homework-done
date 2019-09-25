package Titlovi;

public class SubRipSubtitle extends Subtitle {
    private int hoursBegin;
    private int minutesBegin;
    private int secondsBegin;
    private int milisBegin;
    private int hoursEnd;
    private int minutesEnd;
    private int secondsEnd;
    private int milisEnd;

    public SubRipSubtitle(String text, int titlNum, int hoursB, int minutesB, int secondsB, int milisB, int hoursE, int minutesE, int secondsE, int milisE) {
        super(text, titlNum);
        this.hoursBegin = hoursB;
        this.minutesBegin = minutesB;
        this.secondsBegin = secondsB;
        this.milisBegin = milisB;
        this.hoursEnd = hoursE;
        this.minutesEnd = minutesE;
        this.secondsEnd = secondsE;
        this.milisEnd = milisE;
    }

    public int getHoursBegin() {
        return hoursBegin;
    }

    public void setHoursBegin(int hoursBegin) {
        this.hoursBegin = hoursBegin;
    }

    public int getMinutesBegin() {
        return minutesBegin;
    }

    public void setMinutesBegin(int minutesBegin) {
        this.minutesBegin = minutesBegin;
    }

    public int getSecondsBegin() {
        return secondsBegin;
    }

    public void setSecondsBegin(int secondsBegin) {
        this.secondsBegin = secondsBegin;
    }

    public int getMilisBegin() {
        return milisBegin;
    }

    public void setMilisBegin(int milisBegin) {
        this.milisBegin = milisBegin;
    }

    public int getHoursEnd() {
        return hoursEnd;
    }

    public void setHoursEnd(int hoursEnd) {
        this.hoursEnd = hoursEnd;
    }

    public int getMinutesEnd() {
        return minutesEnd;
    }

    public void setMinutesEnd(int minutesEnd) {
        this.minutesEnd = minutesEnd;
    }

    public int getSecondsEnd() {
        return secondsEnd;
    }

    public void setSecondsEnd(int secondsEnd) {
        this.secondsEnd = secondsEnd;
    }

    public int getMilisEnd() {
        return milisEnd;
    }

    public void setMilisEnd(int milisEnd) {
        this.milisEnd = milisEnd;
    }

    //-------------------------------------------------------------------

    public double getSecondsFromBegin(){
        double s = 0;
        s+= hoursBegin * 3600;
        s+= minutesBegin * 60;
        s+= secondsBegin;
        s=s+ (double)milisBegin / 1000;
        return s;
    }

    public double getSecondsFromEnd(){
        double s = 0;
        s+= hoursEnd * 3600;
        s+= minutesEnd * 60;
        s+= secondsEnd;
        s= s + (double)milisEnd / 1000;
        return s;
    }

    public int getMilisFromBegin(){
        int s = 0;
        s+= hoursBegin * 3600;
        s+= minutesBegin * 60;
        s+= secondsBegin;
        s = s*1000 + milisBegin;
        return s;
    }

    public int getMilisFromEnd(){
        int s = 0;
        s+= hoursEnd * 3600;
        s+= minutesEnd * 60;
        s+= secondsEnd;
        s = s*1000 + milisEnd;
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTitlNum() + "\n");
        sb.append(hoursBegin + ":" + minutesBegin + ":" + secondsBegin + "," + milisBegin + " --> " + hoursEnd + ":" + minutesEnd + ":" + secondsEnd + "," + milisEnd + "\n");
        sb.append(super.getText() + "\n\n");
        return sb.toString();
    }
}
