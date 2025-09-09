package StreamAPI;

import java.time.LocalDateTime;
import java.util.*;

public class ForEachExamples {
    public static void main(String[] args) {
        // 1. Stock Price Logger
        List<Double> stockPrices = Arrays.asList(101.5, 102.7, 99.9);
        System.out.println("Stock Prices:");
        stockPrices.forEach(price -> System.out.println("Price: " + price));
        System.out.println();

        // 2. Event Attendee Welcome Message
        List<String> attendees = Arrays.asList("Ravi", "Neha", "Amit");
        attendees.forEach(name -> System.out.println("Welcome " + name + "!"));

        // 3. IoT Sensor Readings
        List<Integer> readings = Arrays.asList(30, 55, 70, 20);
        System.out.println("\nSensor Readings above 50:");
        readings.stream()
                .filter(r -> r > 50)
                .forEach(r -> System.out.println("Reading: " + r));
        System.out.println();
        // 4. Email Notifications
        List<String> emails = Arrays.asList("user1@example.com", "user2@example.com");
        emails.forEach(email -> System.out.println("Sending email to: " + email));
        System.out.println();
        // 5. Logging Transactions
        List<String> transactionIds = Arrays.asList("TXN1001", "TXN1002", "TXN1003");
        transactionIds.forEach(id ->
                System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
