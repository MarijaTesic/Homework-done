package Titlovi;

import java.io.*;
import java.util.ArrayList;

public class SubRipSubtitleList {
    private ArrayList<SubRipSubtitle> list;

    public SubRipSubtitleList() {
        list = new ArrayList<>();
    }

    public SubRipSubtitleList(ArrayList<SubRipSubtitle> list) {
        this.list = list;
    }

    public ArrayList<SubRipSubtitle> getList() {
        return list;
    }

    public void setList(ArrayList<SubRipSubtitle> list) {
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

    //----------------------------------------------------

    public void read(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int titleNum = 1;

            while(true){
                String line = br.readLine();
                if(line==null)return;
                line = br.readLine();

                String[] tokens = line.split(" --> ");

                String[] timeB = tokens[0].split(":");
                int hoursB = Integer.parseInt(timeB[0]);
                int minutesB = Integer.parseInt(timeB[1]);
                String[] secondsAndMilisB = timeB[2].split(",");
                int secondsB = Integer.parseInt(secondsAndMilisB[0]);
                int milisB = Integer.parseInt(secondsAndMilisB[1]);

                String[] timeE = tokens[1].split(":");
                int hoursE = Integer.parseInt(timeE[0]);
                int minutesE = Integer.parseInt(timeE[1]);
                String[] secondsAndMilisE = timeE[2].split(",");
                int secondsE = Integer.parseInt(secondsAndMilisE[0]);
                int milisE = Integer.parseInt(secondsAndMilisE[1]);

                String text = "";

                line = br.readLine();
                while(true){
                    text+=line;
                    line = br.readLine();
                    if(line == null || line.equals(""))break;
                    text+="\n";
                }

                SubRipSubtitle srs = new SubRipSubtitle(text, titleNum++, hoursB, minutesB, secondsB, milisB, hoursE, minutesE, secondsE, milisE);
                list.add(srs);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MplayerSubtitleList convertToMplayer(){
        double prevEnd = 0;
        ArrayList<MPlayerSubtitle> list2 = new ArrayList<>();

        for(SubRipSubtitle s:list){
            int titleNum = s.getTitlNum();
            String text = s.getText();

            double mFromB = s.getMilisFromBegin();
            double mFromE = s.getMilisFromEnd();

            double delay = (mFromB - prevEnd)/1000;
            double duration = (mFromE - mFromB)/1000;

            prevEnd = mFromE;

            list2.add(new MPlayerSubtitle(text, titleNum, delay, duration));
        }
        return new MplayerSubtitleList(list2);
    }

    public MicroDVDSubtitleList convertToMicroDVD(){
        ArrayList<MicroDVDSubtitle> list2 = new ArrayList<>();

        for(SubRipSubtitle s:list){
            double secondsB = s.getSecondsFromBegin();
            double secondsE = s.getSecondsFromEnd();
            String text = s.getText();
            int titleNum = s.getTitlNum();

            int frameBegin = (int) (secondsB/MicroDVDSubtitle.frameDuration);
            int frameEnd = (int) (secondsE/MicroDVDSubtitle.frameDuration);

            text = text.replace('\n', '|');

            MicroDVDSubtitle mds = new MicroDVDSubtitle(text, titleNum, frameBegin, frameEnd);
            list2.add(mds);
        }
        return new MicroDVDSubtitleList(list2);
    }
}
