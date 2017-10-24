package helpers;

import org.joda.time.DateTime;

public class UtilityClass {

    public static Boolean intervalsOverlapping(DateTime start1, DateTime end1, DateTime start2, DateTime end2) {
        return (start2.isAfter(start1) && end1.isAfter(start2)) || (end2.isAfter(start1) && end1.isAfter(end2));
    }
}
