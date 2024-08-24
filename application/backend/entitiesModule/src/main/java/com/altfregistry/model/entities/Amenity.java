package com.altfregistry.model.entities;

public class Amenity {
    private String name;
    private int costPerHour;

    public Amenity() {
    }

    public Amenity(String name, int costPerHour) {
        this.name = name;
        this.costPerHour = costPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
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
