package Lambda_Expressions;

import java.util.*;
import java.util.function.Predicate;

class Alert {
	String message;
	String type; // e.g. "Critical", "General", "Reminder"

	Alert(String message, String type) {
		this.message = message;
		this.type = type;
	}

	@Override
	public String toString() {
		return "[" + type + "] " + message;
	}
}

public class Notification_Filtering {
	public static void main(String[] args) {
		List<Alert> alerts = Arrays.asList(new Alert("High Fever Alert", "Critical"),
				new Alert("Time for medicine", "Reminder"), new Alert("New hospital policy update", "General"));

		// User wants only Critical alerts
		Predicate<Alert> criticalFilter = a -> a.type.equals("Critical");

		alerts.stream().filter(criticalFilter).forEach(System.out::println);
	}
}
