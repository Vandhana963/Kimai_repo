 package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

    public int genRandomNumber() {
        Random r = new Random();
        return r.nextInt();
    }

    public String currentDate() {
        Date d = new Date();
        return sim.format(d);
    }

    public String getRequiredDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        return sim.format(cal.getTime());
    }
}
