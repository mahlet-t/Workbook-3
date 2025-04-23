import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        LocalDateTime today=LocalDateTime.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(format));
        DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(today.format(fmt));
        //GMT time
        ZonedDateTime gmtTime=ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("GMT time:  "+gmtTime.format(DateTimeFormatter.ofPattern("E, MMM,d,yyyy HH:mm")));
        //
        ZonedDateTime localTime=ZonedDateTime.now();
        System.out.println("Local Time Zone:  "+localTime.format(DateTimeFormatter.ofPattern("HH:mm' on' dd-MMM-yyy")));

    }
}
