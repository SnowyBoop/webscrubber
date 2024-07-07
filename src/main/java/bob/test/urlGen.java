package bob.test;
import java.net.*;


public class urlGen {

    public urlGen() {
    }

    public URI genNewUrl(String parsePls) {

        URI toReturn = URI.create(parsePls);

        return toReturn;

    }

}
