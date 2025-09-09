package StreamAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int year;

    Movie(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }
}

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }
}

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class GymMember {
    String name;
    LocalDate expiryDate;

    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class StreamExamples {
    public static void main(String[] args) {

        // 1. Top 5 Trending Movies
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2024),
            new Movie("Movie B", 9.1, 2025),
            new Movie("Movie C", 7.8, 2023),
            new Movie("Movie D", 9.0, 2025),
            new Movie("Movie E", 8.7, 2024),
            new Movie("Movie F", 9.2, 2025)
        );

        System.out.println("Top 5 Trending Movies:");
        movies.stream()
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                      .thenComparing(m -> m.year, Comparator.reverseOrder()))
              .limit(5)
              .forEach(m -> System.out.println(m.title + " (" + m.rating + ", " + m.year + ")"));

        // 2. Hospital Doctor Availability
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Mehta", "Cardiology", true),
            new Doctor("Dr. Singh", "Neurology", false),
            new Doctor("Dr. Nair", "Orthopedic", true)
        );

        System.out.println("\nDoctors available on weekends:");
        doctors.stream()
               .filter(d -> d.availableOnWeekend)
               .sorted(Comparator.comparing(d -> d.specialty))
               .forEach(d -> System.out.println(d.name + " - " + d.specialty));

        // 3. Insurance Claim Analysis
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 2000),
            new Claim("Auto", 5000),
            new Claim("Health", 3000),
            new Claim("Auto", 7000)
        );

        System.out.println("\nAverage Claim Amount by Type:");
        Map<String, Double> avgClaims = claims.stream()
                .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));
        avgClaims.forEach((type, avg) -> System.out.println(type + ": " + avg));

        // 4. Filtering Expiring Memberships (within next 30 days)
        List<GymMember> members = Arrays.asList(
            new GymMember("Ravi", LocalDate.now().plusDays(10)),
            new GymMember("Amit", LocalDate.now().plusDays(40)),
            new GymMember("Neha", LocalDate.now().plusDays(25))
        );

        System.out.println("\nExpiring Memberships in 30 days:");
        members.stream()
               .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
               .forEach(m -> System.out.println(m.name + " - Expires on: " + m.expiryDate));

        // 5. Transforming Names for Display
        List<String> customers = Arrays.asList("rahul", "amit", "neha", "kavita");
        System.out.println("\nCustomer Names (Uppercase & Sorted):");
        customers.stream()
                 .map(String::toUpperCase)
                 .sorted()
                 .forEach(System.out::println);
    }
}
