import java.util.*;

public class BookMyStay {

    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay App v1.0\n");

        // UC2
        Room single = new Room("Single", 1, 50);
        Room doubleRoom = new Room("Double", 2, 90);
        Room suite = new Room("Suite", 3, 150);

        single.displayRoom();
        doubleRoom.displayRoom();
        suite.displayRoom();
        System.out.println();

        // UC3
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 10);
        inventory.put("Double", 5);
        inventory.put("Suite", 2);

        // UC4
        Room[] rooms = {single, doubleRoom, suite};
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (inventory.get(room.type) > 0) {
                room.displayRoom();
                System.out.println("Available: " + inventory.get(room.type));
            }
        }
        System.out.println();

        // UC5
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.offer(new Reservation("Alice", "Single"));
        bookingQueue.offer(new Reservation("Bob", "Double"));
        bookingQueue.offer(new Reservation("Charlie", "Suite"));

        // UC6: Room Allocation
        Set<String> allocatedRoomIds = new HashSet<>();
        HashMap<String, Set<String>> allocations = new HashMap<>();

        while (!bookingQueue.isEmpty()) {
            Reservation res = bookingQueue.poll();
            int available = inventory.get(res.roomType);

            if (available > 0) {
                String roomId = res.roomType.substring(0,1).toUpperCase() + (allocatedRoomIds.size() + 101);
                allocatedRoomIds.add(roomId);

                allocations.computeIfAbsent(res.roomType, k -> new HashSet<>()).add(roomId);
                inventory.put(res.roomType, available - 1);

                System.out.println(res.guestName + " booked " + res.roomType + " | Room ID: " + roomId);
            } else {
                System.out.println(res.guestName + " booking failed: No " + res.roomType + " rooms available.");
            }
        }
    }
}