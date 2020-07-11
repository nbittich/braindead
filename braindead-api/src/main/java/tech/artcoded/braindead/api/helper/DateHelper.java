package tech.artcoded.braindead.api.helper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public interface DateHelper {
  static String formatCurrentDateForFilename() {
    return ZonedDateTime.now(ZoneId.of("Europe/Paris"))
        .truncatedTo(ChronoUnit.MINUTES)
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm"));
  }
}