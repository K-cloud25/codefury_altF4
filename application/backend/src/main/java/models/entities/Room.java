package models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Room {
    private int roomID;
    private String roomType;
    private int seatingCapacity;
    private List<Amenity> amenities;

    public Room() {
    }

    public Room(int roomID, String roomType, int seatingCapacity, List<Amenity> amenities) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.seatingCapacity = seatingCapacity;
        this.amenities = new ArrayList<>();
        addDefaultAmenities();

    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomType='" + roomType + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", amenities=" + amenities +
                '}';
    }

    //add default amenities according to room type in list of amenities with cost per hour
    private void addDefaultAmenities() {
        switch (roomType.toLowerCase()){
            case "classroomtraining":
                amenities.add(new Amenity("Whiteboard",5)); //add amenity and cost per hour of it
                amenities.add(new Amenity("Projector",5));
                break;
                case "onlinetraining":
                    amenities.add(new Amenity("WiFi",10));
                    amenities.add(new Amenity("Projector",5));
                    break;
            case "conferencecall":
                amenities.add(new Amenity("ConferenceCallFacility",15));
                break;
            case "business":
                amenities.add(new Amenity("Projector",5));
                break;
                default:
                    break;
        }

    }
    public double calTotalCostPerHour(){
        double totalCost = 0;
        for (Amenity amenity : amenities){
            totalCost += amenity.getCostPerHour();
        }
        return totalCost;
    }

}
