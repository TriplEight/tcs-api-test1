import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCodeNameMatch() throws JSONException, FileNotFoundException, ParseException  {
        JSONObject jsonObj = new JSONObject(Main.getData());
        JSONObject payload = jsonObj.getJSONObject("payload");
        JSONArray jsonArray = payload.getJSONArray("rates");

        /*Parse API*/
        for (int i = 0; i < jsonArray.length(); i++) {

            String toCurr = jsonArray.getJSONObject(i).getJSONObject("toCurrency").toString();
            String fromCurr = jsonArray.getJSONObject(i).getJSONObject("fromCurrency").toString();

            String usd = "{\"code\":840,\"name\":\"USD\"}";
            String rub = "{\"code\":643,\"name\":\"RUB\"}";
            String eur = "{\"code\":978,\"name\":\"EUR\"}";
            String gbp = "{\"code\":826,\"name\":\"GBP\"}";

            /*Check fromCurrency*/
            if (fromCurr.contains("\"code\":840")) {
                assertEquals(fromCurr, usd);
            } else if (fromCurr.contains("\"code\":643")) {
                assertEquals(fromCurr, rub);
            } else if (fromCurr.contains("\"code\":978")) {
                assertEquals(fromCurr, eur);
            } else if (fromCurr.contains("\"code\":826")) {
                assertEquals(fromCurr, gbp);
            } else {
                fail("Wrong currency" + " " + fromCurr);
            }

            /*Check toCurrency*/
            if (toCurr.contains("\"code\":840")) {
                assertEquals(toCurr, usd);
            } else if (toCurr.contains("\"code\":643")) {
                assertEquals(toCurr, rub);
            } else if (toCurr.contains("\"code\":978")) {
                assertEquals(toCurr, eur);
            } else if (toCurr.contains("\"code\":826")) {
                assertEquals(toCurr, gbp);
            } else {
                fail("Wrong currency" + " " + toCurr);
            }
        }
    }
}