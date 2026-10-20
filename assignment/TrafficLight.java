package week7Assignment;

/**
 * Problem 4: The Traffic Light
 * Scenario: A traffic light cycles through red, green, and yellow, in order.
 */
public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void next() {
        if ("RED".equalsIgnoreCase(color)) {
            color = "GREEN";
        } else if ("GREEN".equalsIgnoreCase(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equalsIgnoreCase(color)) {
            color = "RED";
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());

        t.next();
        System.out.println("t.next() -> " + t.getColor());
    }
}