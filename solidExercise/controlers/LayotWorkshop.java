package solidExercise.controlers;

import solidExercise.interfaces.Layout;
import solidExercise.interfaces.LayoutFactory;

public class LayotWorkshop implements LayoutFactory {
    @Override
    public Layout produce(String type) {
        return switch (type){
            case "SimpleLayout" -> new SimpleLayout();
            case "XmlLayout" -> new XmlLayout();
            default -> throw new IllegalStateException("Not valid type of layout for "
                    +type+ " param");
        };
    }
}
