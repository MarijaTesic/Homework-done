package Titlovi;

import java.io.*;
import java.util.ArrayList;

public class MicroDVDSubtitleList {
    private ArrayList<MicroDVDSubtitle> list;

    public MicroDVDSubtitleList() {
        list = new ArrayList<>();
    }

    public MicroDVDSubtitleList(ArrayList<MicroDVDSubtitle> list) {
        this.list = list;
    }

    public ArrayList<MicroDVDSubtitle> getList() {
        return list;
    }

    public void setList(ArrayList<MicroDVDSubtitle> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Subtitle s:list){
            sb.append(s.toString());
        }
        return sb.toString();
    }

    public void print(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------

    public void read(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int titleNum = 1;

            String line = br.readLine();
            while(line!=null){
                int startFrame=0;
                int endFrame=0;
                String text = "";

                String[] tokens = line.split("}");
                text = tokens[2];
                startFrame = Integer.parseInt(tokens[0].substring(1));
                endFrame = Integer.parseInt(tokens[1].substring(1));

                MicroDVDSubtitle mds = new MicroDVDSubtitle(text, titleNum++, startFrame, endFrame);
                list.add(mds);

                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SubRipSubtitleList convertToSubRip(){
        ArrayList<SubRipSubtitle> list2 = new ArrayList<>();

        for(MicroDVDSubtitle s:list) {
            String text = s.getText();
            int titleNum = s.getTitlNum();
            int frameBegin = s.getFrameBegin();
            int frameEnd = s.getFrameEnd();

            double secondsFromBegin = frameBegin*MicroDVDSubtitle.frameDuration;
            double secondsFromEnd = frameEnd*MicroDVDSubtitle.frameDuration;

            int milisB = (int) ((secondsFromBegin - (int)secondsFromBegin)*1000);
            int milisE = (int) ((secondsFromEnd - (int)secondsFromEnd)*1000);

            int hoursB = (int) (secondsFromBegin / 3600);
            int hoursE = (int) (secondsFromEnd / 3600);

            int secondsB = (int) (secondsFromBegin % 60);
            int secondsE = (int) (secondsFromEnd % 60);

            int minutesB = (int) ((secondsFromBegin - hoursB*3600)/60);
            int minutesE = (int) ((secondsFromEnd - hoursE*3600)/60);

            text = text.replace('|', '\n');

            SubRipSubtitle srs = new SubRipSubtitle(text, titleNum, hoursB, minutesB, secondsB, milisB, hoursE, minutesE, secondsE, milisE);
            list2.add(srs);
        }

        return new SubRipSubtitleList(list2);
    }

    public MplayerSubtitleList convertToMPlayer(){
        ArrayList<MPlayerSubtitle> list2 = new ArrayList<>();
        int prevEnd = 0;

        for(MicroDVDSubtitle s:list){
            String text = s.getText();
            int titleNum = s.getTitlNum();
            int frameBegin = s.getFrameBegin();
            int frameEnd = s.getFrameEnd();

            double delay = (frameBegin - prevEnd)*MicroDVDSubtitle.frameDuration;
            double duration = (frameEnd - frameBegin)*MicroDVDSubtitle.frameDuration;

            text = text.replace('|', '\n');

            MPlayerSubtitle mps = new MPlayerSubtitle(text, titleNum, delay, duration);
            list2.add(mps);

            prevEnd = frameEnd;
        }
        return new MplayerSubtitleList(list2);
    }
}
