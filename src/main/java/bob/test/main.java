package bob.test;
import java.net.*;
import java.util.ArrayList.*;
import java.util.LinkedHashSet;
import java.util.StringJoiner;


public class main {

    public static void main(String args[]) {

    LinkedHashSet<String> ips = new LinkedHashSet<>();

    for(int i = 0; i<255 ; i++) {
        for(int j = 0; j < 255 ; j++) {
            for(int k = 0; k < 255; k++) {
                for(int l = 0; l < 255 ; l++) {

                    String toAdd =  Integer.toString(i) + "." +
                                    Integer.toString(j) + "." +
                                    Integer.toString(k) + "." +
                                    Integer.toString(l);
                    System.out.println(toAdd);

                    ips.add(toAdd);
                }

            }

        }

    }

    }

}
