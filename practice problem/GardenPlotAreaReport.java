package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Garden Plot Area Report
 * Demonstrates Abstraction with Abstract Class Plot.
 */
abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract String getShape();
    public abstract double calculateArea();

    public void displayReport() {
        System.out.printf("%s (%s): %.2f%n", owner, getShape(), calculateArea());
    }
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void generateReport(List<Plot> plots) {
        double totalArea = 0;
        for (Plot plot : plots) {
            plot.displayReport();
            totalArea += plot.calculateArea();
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }

    public static void main(String[] args) {
        List<Plot> plots = new ArrayList<>();
        plots.add(new CirclePlot("Asha", 5));
        plots.add(new RectanglePlot("Ravi", 4, 6));
        plots.add(new TrianglePlot("Neha", 10, 3));

        generateReport(plots);
    }
}
