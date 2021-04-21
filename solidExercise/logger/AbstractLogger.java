package solidExercise.logger;

import solidExercise.enums.ReportLevel;
import solidExercise.interfaces.Appender;
import solidExercise.interfaces.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractLogger implements Logger {
    private List<Appender> appended;

    public AbstractLogger(Appender... appended) {
        this.appended = new ArrayList<>(Arrays.asList(appended));
    }

    @Override
    public void logOnConsole() {

    }

    @Override
    public void logInfo(String date, String message) {
        this.callAllApenders(date, ReportLevel.INFO,message);

    }

    @Override
    public void logWarning(String date, String message) {
        this.callAllApenders(date,ReportLevel.WARNING,message);

    }

    @Override
    public void logError(String date, String message) {
        this.callAllApenders(date,ReportLevel.ERROR,message);

    }

    @Override
    public void logCritical(String date, String message) {
        this.callAllApenders(date,ReportLevel.CRITICAL,message);

    }

    @Override
    public void logFatal(String date, String message) {
        this.callAllApenders(date,ReportLevel.FATAL,message);

    }
    private void callAllApenders(String date, ReportLevel reportLevel, String message){
        for (Appender appender : appended) {
            appender.append(date, reportLevel, message);

        }
    }

    @Override
    public void addAppender(Appender appender) {
        this.appended.add(appender);
    }
}
