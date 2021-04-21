package solidExercise.controlers;

import solidExercise.enums.ReportLevel;
import solidExercise.interfaces.Layout;


public class ConsoleAppender extends AbstractAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(getLayout().format(date, reportLevel, message));
    }
}
