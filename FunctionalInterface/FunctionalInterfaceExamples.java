package FunctionalInterface;

import java.util.function.*;

class FunctionalInterfaceExamples {
    public static void runExamples() {
        // Temperature Alert System
        Predicate<Double> temperatureAlert = t -> t > 38.0;
        System.out.println("High temp? " + temperatureAlert.test(39.5));

        // String Length Checker
        Function<String, Integer> lengthChecker = msg -> msg.length();
        System.out.println("Message length: " + lengthChecker.apply("Hello World"));

        // Background Job Execution
        Runnable job = () -> System.out.println("Background job running...");
        new Thread(job).start();
    }
}
