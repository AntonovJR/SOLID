package solidExercise.controlers;

import solidExercise.interfaces.Appender;
import solidExercise.interfaces.AppenderFactory;
import solidExercise.interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {
    @Override
    public Appender produce(String type, Layout layout) {
        return switch (type){
            case "ConsoleAppender" -> new ConsoleAppender(layout);
            case "FileAppender" -> new FileAppender(layout);
            default -> throw new IllegalStateException("Not valid type of appender for "
                    +type+ " param");
        };
    }
}
