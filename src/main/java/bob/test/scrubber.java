package bob.test;
import java.util.LinkedHashSet;
import java.net.*;
import

public class scrubber {

    public scrubber() {

    }


    /**
     * DO NOT RUN THIS FOR NOW XD ITS RAM KILLER AND CPU STRESS TEST!!!
     */
    public void startScrub() {
        LinkedHashSet<String> ips = new LinkedHashSet<>();

        for(int i = 0; i<255 ; i++) {
            for(int j = 0; j < 255 ; j++) {
                for(int k = 0; k < 255; k++) {
                    for(int l = 0; l < 255 ; l++) {

                        String convToURL =
                                        "https://" +
                                        Integer.toString(i) + "." +
                                        Integer.toString(j) + "." +
                                        Integer.toString(k) + "." +
                                        Integer.toString(l);

                        try {
                            URL toScrub = new URI(convToURL).toURL();

                            HttpURLConnection conn = (HttpURLConnection) toScrub.openConnection();
                            conn.setRequestMethod("GET");



                            System.out.println(toGet);

                        } catch(Exception e ) {
                            System.out.println(e);
                        }

                }

            }

        }

    }
        
    }
}
