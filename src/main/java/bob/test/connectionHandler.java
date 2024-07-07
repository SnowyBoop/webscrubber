package bob.test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class connectionHandler extends Thread {

    public String convToURL;

    public connectionHandler(String inputURL) {

        convToURL = inputURL;

    }
    public void run()
    {
        try {

            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running and trying to scrub: " + convToURL);
            try {
                URL toScrub = new URI(convToURL).toURL();

                HttpURLConnection conn = (HttpURLConnection) toScrub.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(10000);

                int responseCode = conn.getResponseCode();

                System.out.println(responseCode);

            } catch(Exception e ) {
                System.out.println(e);
            }
        }
        catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}