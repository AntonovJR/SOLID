package solidExercise.logger;

import solidExercise.interfaces.File;

public class LogFile implements File {
    private StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.builder.append(text);
    }
}
