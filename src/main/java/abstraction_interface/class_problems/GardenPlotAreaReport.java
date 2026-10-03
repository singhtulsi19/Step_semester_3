import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    public abstract double getArea();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static Plot createPlot(String shape, String owner, double first, double second) {
        if (shape.equals("CIRCLE")) {
            return new CirclePlot(owner, first);
        }
        if (shape.equals("RECTANGLE")) {
            return new RectanglePlot(owner, first, second);
        }
        return new TrianglePlot(owner, first, second);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            double first = sc.nextDouble();
            double second = 0;

            if (!shape.equals("CIRCLE")) {
                second = sc.nextDouble();
            }

            Plot plot = createPlot(shape, owner, first, second);
            double area = plot.getArea();
            System.out.printf("%s (%s): %.2f%n", owner, shape, area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}
