package code.localtest;

/*
* import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

*/

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class LocalTest {

    protected static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static void main(String[] args) {

        String abc = "abcdefghijklmn";
        System.out.println("abc = " + abc.lastIndexOf("mn"));

        Long lastExecTime = 0L;
        Long now = System.currentTimeMillis();
        if(lastExecTime == 0L){
            lastExecTime = now - 300000L; // start from 5 min ago
        }
        String startDate = formatter.print(new DateTime(lastExecTime, DateTimeZone.UTC));
        String endDate = formatter.print(new DateTime(/*now*/ now - 300000L, DateTimeZone.UTC));
        String url ="https://www.fleettrackingsimplicity.com/REST2/vehiclehistory/1?startdate="+startDate+"&enddate="+endDate;

        System.out.println("now = " + now);
        System.out.println("lastExecTime = " + lastExecTime);

        System.out.println("url = " + url);

    }

}
