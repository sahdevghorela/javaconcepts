package java8.time;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class JavaTimeDemo {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Instant.now() is "+now);

        Instant then = now.plus(1, ChronoUnit.DAYS);
        Duration elapsed = Duration.between(now,then);
        System.out.println("Duration after adding 1 day "+ elapsed);
        System.out.println("Duration in days "+ elapsed.toDays());
        System.out.println("Duration in hours "+ elapsed.toHours());

        then = now.plus(1,ChronoUnit.DAYS)
                .plus(1,ChronoUnit.HALF_DAYS)
                .plus(1,ChronoUnit.HOURS)
                .plus(1,ChronoUnit.MINUTES)
                .plusSeconds(100)
                .plusMillis(100)
                .plusNanos(100);
        System.out.println("Adding units to now:"+then);

        LocalDate localDate1 = LocalDate.now();
        System.out.println("LocalDate.now() is "+localDate1);

        LocalDate groundHodDay = LocalDate.of(2016, Month.FEBRUARY,2);
        System.out.println("Groundhod day 2016, is "+groundHodDay);

        LocalDate firstDayOfSpring = LocalDate.of(2016,Month.MARCH,20);
        System.out.println("First day of spring 2016, is "+firstDayOfSpring);

        long gap = groundHodDay.until(firstDayOfSpring,ChronoUnit.DAYS);
        System.out.println("There are "+gap + " days between groundhogday and first day of springg");
        System.out.println("That is "+gap/7 + " weeks and "+ gap%7 + " days");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream()
                .filter( zoneId -> zoneId.contains("America"))
                .forEach(System.out::println);

        ZonedDateTime missing = ZonedDateTime.of(
                LocalDate.of(2016,Month.MARCH,13),
                LocalTime.of(2,30),
                ZoneId.of("America/New_York"));
        System.out.println("Missing is "+missing);

        ZonedDateTime spring = ZonedDateTime.of(2016,Month.MARCH.getValue(),20,0,0,0,0,ZoneId.systemDefault());

        System.out.println("Formatted:"+ DateTimeFormatter.RFC_1123_DATE_TIME.format(spring));
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                .withLocale(Locale.FRANCE);
        System.out.println("Formatted French:"+formatter.format(spring));
    }
}
