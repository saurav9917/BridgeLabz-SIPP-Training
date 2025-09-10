import java.time.LocalTime;
import java.time.Duration;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class SmartCityApp {

     // -------------------- TransportService Interface --------------------
     interface TransportService {
          String getId();

          String getType(); // e.g., "Bus", "Metro", "Taxi", "Ferry"

          String getRoute(); // short route name/id

          LocalTime getDeparture(); // next departure time

          double getBaseFare();

          boolean isActive();

          default void printServiceDetails() {
               System.out.printf("%s [%s] - Route: %s, Departs: %s, Fare: ₹%.2f%n",
                         getType(), getId(), getRoute(), getDeparture(), getBaseFare());
          }
     }

     // -------------------- GeoUtils interface with static methods
     // --------------------
     interface GeoUtils {
          static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
               double dx = lat1 - lat2;
               double dy = lon1 - lon2;
               return Math.sqrt(dx * dx + dy * dy) * 111; // approx km scale
          }
     }

     // -------------------- Marker Interface for emergency-capable services
     // --------------------
     interface EmergencyService {
     }

     // -------------------- Functional Interface: FareCalculator
     // --------------------
     @FunctionalInterface
     interface FareCalculator {
          double calculateFare(TransportService service, double distanceKm, LocalTime travelTime);
     }

     // -------------------- Concrete Transport Services --------------------
     static class BusService implements TransportService {
          private final String id, route;
          private final LocalTime departure;
          private final double fare;
          private final boolean active;

          BusService(String id, String route, LocalTime departure, double fare, boolean active) {
               this.id = id;
               this.route = route;
               this.departure = departure;
               this.fare = fare;
               this.active = active;
          }

          public String getId() {
               return id;
          }

          public String getType() {
               return "Bus";
          }

          public String getRoute() {
               return route;
          }

          public LocalTime getDeparture() {
               return departure;
          }

          public double getBaseFare() {
               return fare;
          }

          public boolean isActive() {
               return active;
          }
     }

     static class MetroService implements TransportService {
          private final String id, route;
          private final LocalTime departure;
          private final double fare;
          private final boolean active;

          MetroService(String id, String route, LocalTime departure, double fare, boolean active) {
               this.id = id;
               this.route = route;
               this.departure = departure;
               this.fare = fare;
               this.active = active;
          }

          public String getId() {
               return id;
          }

          public String getType() {
               return "Metro";
          }

          public String getRoute() {
               return route;
          }

          public LocalTime getDeparture() {
               return departure;
          }

          public double getBaseFare() {
               return fare;
          }

          public boolean isActive() {
               return active;
          }
     }

     static class TaxiService implements TransportService {
          private final String id, route;
          private final LocalTime departure;
          private final double fare;
          private final boolean active;

          TaxiService(String id, String route, LocalTime departure, double fare, boolean active) {
               this.id = id;
               this.route = route;
               this.departure = departure;
               this.fare = fare;
               this.active = active;
          }

          public String getId() {
               return id;
          }

          public String getType() {
               return "Taxi";
          }

          public String getRoute() {
               return route;
          }

          public LocalTime getDeparture() {
               return departure;
          }

          public double getBaseFare() {
               return fare;
          }

          public boolean isActive() {
               return active;
          }
     }

     // Example emergency-capable service
     static class AmbulanceService implements TransportService, EmergencyService {
          private final String id, route;
          private final LocalTime departure;
          private final double fare;
          private final boolean active;

          AmbulanceService(String id, String route, LocalTime departure, double fare, boolean active) {
               this.id = id;
               this.route = route;
               this.departure = departure;
               this.fare = fare;
               this.active = active;
          }

          public String getId() {
               return id;
          }

          public String getType() {
               return "Ambulance";
          }

          public String getRoute() {
               return route;
          }

          public LocalTime getDeparture() {
               return departure;
          }

          public double getBaseFare() {
               return fare;
          }

          public boolean isActive() {
               return active;
          }

          // override default printing to show emergency tag
          @Override
          public void printServiceDetails() {
               System.out.printf("%s [%s] (EMERGENCY) - Route: %s, Departs: %s%n",
                         getType(), getId(), getRoute(), getDeparture());
          }
     }

     // -------------------- Passenger record --------------------
     static class Passenger {
          String id;
          String name;
          String route;
          LocalTime travelTime;
          double paidFare;
          double distanceKm;

          Passenger(String id, String name, String route, LocalTime travelTime, double distanceKm, double paidFare) {
               this.id = id;
               this.name = name;
               this.route = route;
               this.travelTime = travelTime;
               this.distanceKm = distanceKm;
               this.paidFare = paidFare;
          }

          public String getRoute() {
               return route;
          }

          public LocalTime getTravelTime() {
               return travelTime;
          }

          public double getPaidFare() {
               return paidFare;
          }

          public double getDistanceKm() {
               return distanceKm;
          }
     }

     // -------------------- Demo & utility --------------------
     public static void main(String[] args) {

          // 1) Create services (sample data)
          List<TransportService> services = new ArrayList<>();
          services.add(new BusService("B100", "R1", LocalTime.of(9, 0), 30.0, true));
          services.add(new BusService("B101", "R2", LocalTime.of(9, 15), 25.0, true));
          services.add(new MetroService("M10", "R1", LocalTime.of(8, 50), 20.0, true));
          services.add(new TaxiService("T500", "R3", LocalTime.of(9, 5), 80.0, true));
          services.add(new AmbulanceService("AMB1", "R4", LocalTime.of(0, 0), 0.0, true)); // emergency

          // 2) FareCalculator implemented with lambda (distance-based + base fare)
          FareCalculator fareCalc = (service, distanceKm, travelTime) -> {
               boolean isPeak = isPeakTime(travelTime);
               double base = service.getBaseFare();
               double perKm = 10.0; // flat per-km
               double fare = base + perKm * distanceKm;
               if (isPeak)
                    fare *= 1.2;
               return Math.round(fare * 100.0) / 100.0;
          };

          // 3) Simulate passenger bookings (sample data)
          List<Passenger> passengers = Arrays.asList(
                    new Passenger("P1", "Raman", "R1", LocalTime.of(9, 0), 5.0,
                              fareCalc.calculateFare(services.get(0), 5.0, LocalTime.of(9, 0))),
                    new Passenger("P2", "Sonia", "R1", LocalTime.of(8, 50), 3.0,
                              fareCalc.calculateFare(services.get(2), 3.0, LocalTime.of(8, 50))),
                    new Passenger("P3", "Ajay", "R2", LocalTime.of(9, 16), 4.0,
                              fareCalc.calculateFare(services.get(1), 4.0, LocalTime.of(9, 16))),
                    new Passenger("P4", "Deepa", "R3", LocalTime.of(9, 5), 12.0,
                              fareCalc.calculateFare(services.get(3), 12.0, LocalTime.of(9, 5))),
                    new Passenger("P5", "Vikram", "R1", LocalTime.of(18, 0), 8.0,
                              fareCalc.calculateFare(services.get(0), 8.0, LocalTime.of(18, 0))));

          // ---------- A. Filter & Sort services using lambda (e.g., earliest departure
          // then lowest fare) ----------
          System.out.println("== Available services sorted by earliest departure then fare ==");
          services.stream()
                    .filter(TransportService::isActive) // lambda method ref
                    .sorted(Comparator.comparing(TransportService::getDeparture)
                              .thenComparing(TransportService::getBaseFare))
                    .forEach(TransportService::printServiceDetails); // method reference to default printer

          // ---------- B. Display live schedules with forEach ----------
          System.out.println("\n== Live Dashboard Schedules ==");
          services.forEach(
                    s -> System.out.println("Dashboard: " + s.getType() + " " + s.getId() + " -> " + s.getDeparture()));

          // ---------- C. Grouping: passengers by route (Collectors.groupingBy)
          // ----------
          System.out.println("\n== Passengers grouped by route ==");
          Map<String, List<Passenger>> groupedByRoute = passengers.stream()
                    .collect(Collectors.groupingBy(Passenger::getRoute));
          groupedByRoute.forEach((route, list) -> {
               System.out.println("Route " + route + " has " + list.size() + " passengers");
          });

          // ---------- D. Partitioning: peak vs non-peak trips
          // (Collectors.partitioningBy) ----------
          System.out.println("\n== Peak vs Non-Peak partition ==");
          Map<Boolean, List<Passenger>> peakPartition = passengers.stream()
                    .collect(Collectors.partitioningBy(p -> isPeakTime(p.getTravelTime())));
          System.out.println("Peak trips: " + peakPartition.get(true).size());
          System.out.println("Non-peak trips: " + peakPartition.get(false).size());

          // ---------- E. Summarizing fares per route (summarizingDouble) ----------
          System.out.println("\n== Fare summary per route ==");
          Map<String, DoubleSummaryStatistics> fareStats = passengers.stream()
                    .collect(Collectors.groupingBy(Passenger::getRoute,
                              Collectors.summarizingDouble(Passenger::getPaidFare)));
          fareStats.forEach((route, stats) -> {
               System.out.printf("Route %s -> count=%d sum=₹%.2f avg=₹%.2f max=₹%.2f%n",
                         route, stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMax());
          });

          // ---------- F. Top-used routes (by passenger count) ----------
          System.out.println("\n== Top-used routes ==");
          groupedByRoute.entrySet().stream()
                    .sorted((e1, e2) -> Long.compare(e2.getValue().size(), e1.getValue().size()))
                    .limit(3)
                    .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue().size() + " rides"));

          // ---------- G. Emergency services prioritization ----------
          System.out.println("\n== Emergency services list ==");
          services.stream()
                    .filter(s -> s instanceof EmergencyService)
                    .forEach(s -> System.out.println("EMERGENCY: " + s.getType() + " " + s.getId()));

          // ---------- H. Real-time sample flow: Passenger searches -> filter & sort
          // ----------
          System.out.println("\n== Passenger searching for earliest R1 service ==");
          String desiredRoute = "R1";
          Optional<TransportService> best = services.stream()
                    .filter(s -> s.getRoute().equals(desiredRoute) && s.isActive())
                    .sorted(Comparator.comparing(TransportService::getDeparture)
                              .thenComparing(TransportService::getBaseFare))
                    .findFirst();
          best.ifPresent(svc -> System.out.println("Recommended: " + svc.getType() + " " + svc.getId()));

          // ---------- I. Show distance util (static method in interface) ----------
          double dist = GeoUtils.calculateDistance(28.5, 77.0, 28.6, 77.1);
          System.out.printf("%nSample distance between coords ≈ %.2f km%n", dist);

          // ---------- J. Demonstrate easy expansion: add FerryService class (lambda
          // style) ----------
          System.out.println("\n== Adding a new service Ferry (demonstrate extensibility) ==");
          // implementing TransportService using anonymous class (could be separate class)
          TransportService ferry = new TransportService() {
               public String getId() {
                    return "F1";
               }

               public String getType() {
                    return "Ferry";
               }

               public String getRoute() {
                    return "R5";
               }

               public LocalTime getDeparture() {
                    return LocalTime.of(10, 0);
               }

               public double getBaseFare() {
                    return 120.0;
               }

               public boolean isActive() {
                    return true;
               }
          };
          ferry.printServiceDetails();
     }

     private static boolean isPeakTime(LocalTime time) {
          // simple rule: peak if between 8:00-10:00 OR 17:00-19:00
          if (time == null)
               return false;
          return (!time.isBefore(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(10, 0)))
                    || (!time.isBefore(LocalTime.of(17, 0)) && time.isBefore(LocalTime.of(19, 0)));
     }
}