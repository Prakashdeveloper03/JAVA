import java.util.ArrayList;
import javax.swing.JOptionPane;

interface CarbonFootprint {
    double getCarbonFootprint();
}

class Building implements CarbonFootprint {
    private String address;
    private int numFloors;
    private double energyConsumption;

    public Building(String address, int numFloors, double energyConsumption) {
        this.address = address;
        this.numFloors = numFloors;
        this.energyConsumption = energyConsumption;
    }

    @Override
    public double getCarbonFootprint() {
        return energyConsumption * 0.5;
    }

    public String getAddress() {
        return address;
    }

    public int getNumFloors() {
        return numFloors;
    }
}

class Car implements CarbonFootprint {
    private String make;
    private String model;
    private double milesPerGallon;

    public Car(String make, String model, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;
    }

    @Override
    public double getCarbonFootprint() {
        return 1000.0 / milesPerGallon;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

class Bicycle implements CarbonFootprint {
    private String brand;
    private int numGears;

    public Bicycle(String brand, int numGears) {
        this.brand = brand;
        this.numGears = numGears;
    }

    @Override
    public double getCarbonFootprint() {
        return 0.0;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumGears() {
        return numGears;
    }
}

public class Main {
    public static void main(String[] args) {
    ArrayList<CarbonFootprint> objects = new ArrayList<>();
    String address = JOptionPane.showInputDialog(null, "Enter the address of the building:");
    int floors = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of floors in the building:"));
    double squareFootage = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the square footage of the building:"));
    objects.add(new Building(address, floors, squareFootage));
    
    String make = JOptionPane.showInputDialog(null, "Enter the make of the car:");
    String model = JOptionPane.showInputDialog(null, "Enter the model of the car:");
    double mpg = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the miles per gallon of the car:"));
    objects.add(new Car(make, model, mpg));
    
    String brand = JOptionPane.showInputDialog(null, "Enter the brand of the bicycle:");
    int numGears = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of gears on the bicycle:"));
    objects.add(new Bicycle(brand, numGears));

    StringBuilder sb = new StringBuilder();
    for (CarbonFootprint obj : objects) {
        String className = obj.getClass().getSimpleName();
        double carbonFootprint = obj.getCarbonFootprint();
        sb.append(className).append(" has a carbon footprint of ").append(carbonFootprint).append(" metric tons of CO2e\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
    }
}
