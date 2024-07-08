package bob.test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                conn.setRequestProperty("User-Agent", "ALLO I LOOK AT WEBSIT");
                conn.setConnectTimeout(10000);

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
			        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			        String inputLine;
			        StringBuffer response = new StringBuffer();

			        while ((inputLine = in.readLine()) != null) {
				        response.append(inputLine);
			            }
			        in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET failed for" + convToURL);
		} 
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