package Titlovi;

import java.io.*;
import java.util.ArrayList;

public class MplayerSubtitleList {
    private ArrayList<MPlayerSubtitle> list;

    public MplayerSubtitleList() {
        list = new ArrayList<>();
    }

    public MplayerSubtitleList(ArrayList<MPlayerSubtitle> list) {
        this.list = list;
    }

    public ArrayList<MPlayerSubtitle> getList() {
        return list;
    }

    public void setList(ArrayList<MPlayerSubtitle> list) {
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

    //------------------------------------------------------------

    public void read(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int titleNum = 1;

            while(true){
                String line = br.readLine();
                if(line==null)return;

                String[] firstLine = line.split(" ");
                double delay = Double.parseDouble(firstLine[0]);
                double duration = Double.parseDouble(firstLine[1]);
                String text = "";

                line = br.readLine();
                while(true){
                    text+=line;
                    line = br.readLine();
                    if(line == null || line.equals(""))break;
                    text+="\n";
                }

                MPlayerSubtitle msp = new MPlayerSubtitle(text, titleNum++ , delay, duration);
                list.add(msp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public SubRipSubtitleList convertToSubRip(){
        ArrayList<SubRipSubtitle> list2 = new ArrayList<>();
        int prevHours = 0;
        int prevMinutes = 0;
        int prevSeconds = 0;
        int prevMilis = 0;

        for(MPlayerSubtitle s: list){
            double delay = s.getDelay();
            double duration = s.getDuration();
            String text = s.getText();
            int titleNum = s.getTitlNum();

            int correction = 0;

            int milisB = prevMilis + (int) ((delay - (int)delay)*1000);
            if(milisB > 999){
                correction = 1;
                milisB-=1000;
            }

            delay = (int)delay;

            int secondsB = (int) (prevSeconds + delay + correction);
            if(secondsB > 60){
                correction = 1;
                secondsB-=60;
            }
            else correction = 0;

            int minutesB = prevMinutes + correction;
            if(minutesB> 60){
                correction=1;
                minutesB-=60;
            }
            else correction=0;

            int hoursB = prevHours + correction;

            correction = 0;

            int milisE = milisB + (int) ((duration - (int)duration)*1000);
            if(milisE > 999){
                correction = 1;
                milisE-=1000;
            }

            duration = (int)duration;

            int secondsE = (int) (secondsB + duration + correction);
            if(secondsE > 60){
                correction = 1;
                secondsE-=60;
            }
            else correction = 0;

            int minutesE = minutesB + correction;
            if(minutesE> 60){
                correction=1;
                minutesE-=60;
            }
            else correction=0;

            int hoursE = hoursB + correction;

            SubRipSubtitle srs = new SubRipSubtitle(text, titleNum, hoursB, minutesB, secondsB, milisB, hoursE, minutesE, secondsE, milisE);
            list2.add(srs);

            prevHours = hoursE;
            prevMinutes = minutesE;
            prevSeconds = secondsE;
            prevMilis = milisE;

        }
        return new SubRipSubtitleList(list2);
    }

    public MicroDVDSubtitleList convertToMicroDVD(){
        ArrayList<MicroDVDSubtitle> list2 = new ArrayList<>();
        double prevEnd = 0;

        for(MPlayerSubtitle s: list){
            double delay = s.getDelay();
            double duration = s.getDuration();
            String text = s.getText();
            int titleNum = s.getTitlNum();

            double curStart = prevEnd + delay;
            double curEnd = curStart + duration;

            int frameBegin = (int) (curStart / MicroDVDSubtitle.frameDuration);
            int frameEnd = (int) (curEnd / MicroDVDSubtitle.frameDuration);

            text = text.replace('\n', '|');

            MicroDVDSubtitle mds = new MicroDVDSubtitle(text, titleNum, frameBegin, frameEnd);
            list2.add(mds);

            prevEnd = curEnd;
        }
        return new MicroDVDSubtitleList(list2);
    }


}
