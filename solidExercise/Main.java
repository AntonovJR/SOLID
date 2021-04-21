package solidExercise;

import solidExercise.controlers.AppenderWorkshop;
import solidExercise.controlers.ConsoleAppender;
import solidExercise.controlers.LayotWorkshop;
import solidExercise.controlers.SimpleLayout;
import solidExercise.enums.ReportLevel;
import solidExercise.interfaces.*;
import solidExercise.logger.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      /*         Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        Logger logger = new MessageLogger(consoleAppender);
        logger.logError("3 / 26 / 2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3 / 26 / 2015 2:08:11 PM", "User Pesho successfully registered.");
*/
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        AppenderFactory appenderFactory = new AppenderWorkshop();
        LayoutFactory layoutFactory = new LayotWorkshop();
        Logger logger1 = new MessageLogger();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            ReportLevel reportLevel = tokens.length == 3
                    ? ReportLevel.valueOf(tokens[2].toUpperCase())
                    : ReportLevel.INFO;
           Appender appender = appenderFactory.produce(tokens[0], layoutFactory.produce(tokens[1]));
        logger1.addAppender(appender);
        }

        String input = scanner.nextLine();
        while(!"END".equals(input)){
           String[] tokens = input.split("\\|");
           ReportLevel reportLevel =  ReportLevel.valueOf(tokens[0]);
           String date = tokens[1];
           String message = tokens[2];

           switch (reportLevel) {
               case INFO -> logger1.logInfo(date, message);
               case WARNING -> logger1.logWarning(date, message);
               case ERROR -> logger1.logError(date, message);
               case CRITICAL -> logger1.logCritical(date, message);
               case FATAL -> logger1.logFatal(date, message);
               default -> throw new IllegalStateException("Unknown enum value for "+reportLevel);
           }
            input = scanner.nextLine();
        }


    }
}
