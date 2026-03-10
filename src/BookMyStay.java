import java.util.*;


abstract class Room {
    private String roomType;
    private double price;
    private String amenities;

    public Room(String roomType, double price, String amenities) {
        this.roomType = roomType;
        this.price = price;
        this.amenities = amenities;
    }

    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public String getAmenities() { return amenities; }

    // Abstract method to be implemented by concrete classes
    public abstract void displayRoomDescription();

    public void displayBaseDetails() {
        System.out.println("Type: " + roomType);
        System.out.println("Price: $" + price + " per night");
        System.out.println("Amenities: " + amenities);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 100.0, "Wi-Fi, Single Bed, Desk");
    }

    @Override
    public void displayRoomDescription() {
        System.out.println("A cozy room perfect for solo travelers.");
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 150.0, "Wi-Fi, Queen Bed, TV");
    }

    @Override
    public void displayRoomDescription() {
        System.out.println("Spacious room featuring a comfortable queen-sized bed.");
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 300.0, "Wi-Fi, King Bed, Mini-bar, Ocean View");
    }

    @Override
    public void displayRoomDescription() {
        System.out.println("Luxury living with premium amenities and extra space.");
    }
}

// --- Main Application ---

public class BookMyStay{
    public static void main(String[] args) {
        System.out.println("=== Book My Stay App (v2.0) ===");
        System.out.println("Initializing Room Domain Model...\n");

        // 1. Domain Object Creation (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // 2. Static Availability Management
        // Note: Using simple variables as per requirements to highlight
        // the need for future Data Structure implementation.
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 1;

        // 3. Displaying Information
        displayRoomStatus(single, singleAvailability);
        displayRoomStatus(doubleRoom, doubleAvailability);
        displayRoomStatus(suite, suiteAvailability);

        System.out.println("------------------------------------");
        System.out.println("System initialized successfully. Application terminating.");
    }

    private static void displayRoomStatus(Room room, int count) {
        System.out.println("------------------------------------");
        room.displayBaseDetails();
        room.displayRoomDescription();
        System.out.println("Current Availability: " + (count > 0 ? count + " rooms left" : "Sold Out"));
    }
}