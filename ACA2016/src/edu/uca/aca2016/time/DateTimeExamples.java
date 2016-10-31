package edu.uca.aca2016.time;

import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTimeExamples{

    public void printToday(){
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
    }

    /* 
     The Date-Time API provides a fluent interface, making the code easy to 
     read. Because most methods do not allow parameters with a null value 
     and do not return a null value, method calls can be chained together 
     and the resulting code can be quickly understood.
     */
    public void fluentDates(){
        LocalDate today = LocalDate.now();

        LocalDate firstday = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of the current month: " + firstday);

        LocalDate july = LocalDate.now().with(Month.JULY).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last day of July: " + july);
    }

    /*
     Most of the classes in the Date-Time API create objects that are 
     immutable, meaning that, after the object is created, it cannot be 
     modified. 
     */
    public void immutableDates(){
        LocalDate dateOfBirth = LocalDate.of(2012,Month.MAY,14);
        LocalDate firstBirthday = dateOfBirth.plusYears(1);

        System.out.println("First birthday: " + firstBirthday);
    }

    // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
    public void formatDate(){
        LocalDate today = LocalDate.now();

        System.out.println("Today with Full Format: " + today.format(DateTimeFormatter.ofPattern("EEEE MMMM, d u")));
    }

    /*
        Find the time between two specific times. This does not consider timezones.
    */
    public void timeDiff(){
        LocalDateTime fromDateTime = LocalDateTime.of(1984,12,16,7,45,55);
        LocalDateTime toDateTime = LocalDateTime.of(2014,9,10,6,40,45);

        LocalDateTime tempDateTime = LocalDateTime.from(fromDateTime);

        long years = tempDateTime.until(toDateTime,ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears(years);

        long months = tempDateTime.until(toDateTime,ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths(months);

        long days = tempDateTime.until(toDateTime,ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays(days);

        long hours = tempDateTime.until(toDateTime,ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours(hours);

        long minutes = tempDateTime.until(toDateTime,ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes(minutes);

        long seconds = tempDateTime.until(toDateTime,ChronoUnit.SECONDS);

        System.out.println(years + " years "
            + months + " months "
            + days + " days "
            + hours + " hours "
            + minutes + " minutes "
            + seconds + " seconds.");
    }
    
    public void timeZones() {
        System.out.println("Eastern Time: " + LocalTime.now(ZoneId.of("US/Eastern")));
        System.out.println("Central Tile: " + LocalTime.now(ZoneId.of("US/Central")));
        System.out.println("Mountain Time: " + LocalTime.now(ZoneId.of("US/Mountain")));
        System.out.println("Pacific Time: " + LocalTime.now(ZoneId.of("US/Pacific")));
    }

    public static void main(String[] args){
        DateTimeExamples dt = new DateTimeExamples();
        
        // method naming convention info: https://docs.oracle.com/javase/tutorial/datetime/overview/naming.html

        dt.printToday();
        dt.fluentDates();
        dt.immutableDates();
        dt.formatDate();
        dt.timeDiff();
        dt.timeZones();
    }
}
