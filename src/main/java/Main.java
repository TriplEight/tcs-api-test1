import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Scanner;


class Main {

    static String getData() throws ParseException {
        String data = null;
        URLConnection connect;
        try {
            connect = new URL("https://www.tinkoff.ru/api/v1/currency_rates/").openConnection();
            Scanner scan = new Scanner(connect.getInputStream());
            scan.useDelimiter("\\Z");
            data = scan.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return data;
    }
}
