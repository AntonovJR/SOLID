package solidExercise.interfaces;

import solidExercise.enums.ReportLevel;

public interface Appender {
     void append(String date, ReportLevel reportLevel, String message);
}
