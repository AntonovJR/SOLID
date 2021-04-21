package solidExercise.controlers;

import solidExercise.interfaces.Appender;
import solidExercise.interfaces.Layout;

public abstract class AbstractAppender implements Appender {
    private Layout layout;
    public AbstractAppender(Layout layout) {
        this.layout = layout;
    }

    protected Layout getLayout() {
        return layout;
    }
}
