package bob.test;
import javax.sound.midi.SysexMessage;
import java.util.LinkedHashSet;
import java.net.*;
import java.util.concurrent.TimeUnit;
public class scrubber {

    public scrubber() {

    }


    /**
     * DO NOT RUN THIS FOR NOW XD ITS RAM KILLER AND CPU STRESS TEST!!!
     */
    public void startScrub() {

        LinkedHashSet<String> ips = new LinkedHashSet<>();
        
        // recursive setup:
        int firstByte = 0;
        int secondByte = 0;
        int thirdByte = 0;
        int fourthByte = 0;

        //Starting Loop -> summons threads with connection handlers.
        while(true) {

            // the Byte to be incremented after GETTING the IP. (This adds randomness to the scrubber)
            int incrementByte = (int) ((Math.random() * (5 - 1)) + 1);

            System.out.print(incrementByte);
            String convToURL = constructRecursiveIP(firstByte,secondByte,thirdByte,fourthByte);

            System.out.println("new attempt: " + convToURL);

            connectionHandler newhandler = new connectionHandler(convToURL);
            newhandler.start();

            //increasing a random Byte of the IP
            switch(incrementByte) {
                case 1: firstByte++; break;
                case 2: secondByte++; break;
                case 3: thirdByte++; break;
                case 4: fourthByte++; break;
            }

            //Timeout the main loop, to prevent filling up all ports of your network card, which can cause driver crashes on Windows
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
    }

    public String getRandomIP() {

        return "http://" +
                Integer.toString(getRandomChunk()) + "." +
                Integer.toString(getRandomChunk()) + "." +
                Integer.toString(getRandomChunk()) + "." +
                Integer.toString(getRandomChunk());

    }

    public int getRandomChunk() {

        return  (int) ((Math.random() * (255 - 1)) + 1);

    }
    
    public String constructRecursiveIP(int firstByte, int secondByte, int thirdByte, int fourthByte) {

        return "http://" +
                Integer.toString(firstByte) + "." +
                Integer.toString(secondByte) + "." +
                Integer.toString(thirdByte) + "." +
                Integer.toString(fourthByte);

    }
}
