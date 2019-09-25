package Titlovi;

public class Main {
    public static void main(String[] args) {
        int option = Integer.parseInt(args[0]);
        String fileIn = args[1];
        String fileOut = args[2];

        if(option == 0){
            MplayerSubtitleList in = new MplayerSubtitleList();
            in.read(fileIn);
            MicroDVDSubtitleList out = in.convertToMicroDVD();
            out.print(fileOut);
        }

        else if(option == 1){
            MplayerSubtitleList in = new MplayerSubtitleList();
            in.read(fileIn);
            SubRipSubtitleList out = in.convertToSubRip();
            out.print(fileOut);
        }

        else if(option == 2){
            SubRipSubtitleList in = new SubRipSubtitleList();
            in.read(fileIn);
            MicroDVDSubtitleList out = in.convertToMicroDVD();
            out.print(fileOut);
        }

        else if(option == 3){
            SubRipSubtitleList in = new SubRipSubtitleList();
            in.read(fileIn);
            MplayerSubtitleList out= in.convertToMplayer();
            out.print(fileOut);
        }

        else if(option == 4){//todo dodavanje 0
            MicroDVDSubtitleList in = new MicroDVDSubtitleList();
            in.read(fileIn);
            SubRipSubtitleList out = in.convertToSubRip();
            out.print(fileOut);
        }

        else if(option == 5){
            MicroDVDSubtitleList in = new MicroDVDSubtitleList();
            in.read(fileIn);
            MplayerSubtitleList out= in.convertToMPlayer();
            out.print(fileOut);
        }
    }
}
