package Titlovi;

public class MPlayerSubtitle extends Subtitle {
    private double delay;
    private double duration;

    public MPlayerSubtitle(String text, int titlNum, double delay, double duration) {
        super(text, titlNum);
        this.delay = delay;
        this.duration = duration;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(delay + " " + duration + "\n" + super.getText() + "\n\n");
        return sb.toString();
    }
}
