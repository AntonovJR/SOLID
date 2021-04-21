package solidExercise.logger;

import solidExercise.interfaces.Appender;

public class MessageLogger extends AbstractLogger {
    public MessageLogger(Appender... appended) {
        super(appended);
    }
}
