package org.ivyinc.eventplanner.common;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());

    public static String format(Instant instant) {
        return instant == null ? null : FORMATTER.format(instant);
    }
}
