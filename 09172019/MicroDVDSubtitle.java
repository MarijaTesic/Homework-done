package Titlovi;

public class MicroDVDSubtitle extends Subtitle{
    public static final int fps = 60;
    public static final double frameDuration = 1.0/fps;
    private int frameBegin;
    private int frameEnd;

    public MicroDVDSubtitle(String text, int titlNum, int frameBegin, int frameEnd) {
        super(text, titlNum);
        this.frameBegin = frameBegin;
        this.frameEnd = frameEnd;
    }

    public int getFrameBegin() {
        return frameBegin;
    }

    public void setFrameBegin(int frameBegin) {
        this.frameBegin = frameBegin;
    }

    public int getFrameEnd() {
        return frameEnd;
    }

    public void setFrameEnd(int frameEnd) {
        this.frameEnd = frameEnd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + frameBegin + "}" + "{" + frameEnd + "}" + super.getText() + "\n");
        return sb.toString();
    }
}
