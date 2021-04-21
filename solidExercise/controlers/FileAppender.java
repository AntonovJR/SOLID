package solidExercise.controlers;

import solidExercise.enums.ReportLevel;
import solidExercise.interfaces.File;
import solidExercise.interfaces.Layout;
import solidExercise.logger.LogFile;

public class FileAppender extends AbstractAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        String formatted = this.getLayout().format(date, reportLevel, message);
        this.file.write(formatted);
    }
}
