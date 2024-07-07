package bob.test;
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

        for(int i = 128; i<193 ; i++) {
            for(int j = 80; j < 200 ; j++) {
                for(int k = 0; k < 255; k++) {
                    for(int l = 0; l < 255 ; l++) {



                        String convToURL =
                                        "https://" +
                                        Integer.toString(i) + "." +
                                        Integer.toString(j) + "." +
                                        Integer.toString(k) + "." +
                                        Integer.toString(l);

                        System.out.println("new attempt: " + convToURL);

                        connectionHandler newhandler = new connectionHandler(convToURL);
                        newhandler.start();
                        try{TimeUnit.MILLISECONDS.sleep(100);}
                            catch(Exception e) {
                            System.out.println(e);
                        }


                }

            }

        }

    }
        
    }
}
