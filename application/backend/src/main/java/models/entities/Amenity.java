package models.entities;

public class Amenity {
    private String name;
    private double costPerHour;

    public Amenity() {
    }

    public Amenity(String name, double costPerHour) {
        this.name = name;
        this.costPerHour = costPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "name='" + name + '\'' +
                ", costPerHour=" + costPerHour +
                '}';
    }
}
