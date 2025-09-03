import java.io.*;
import java.util.*;

public class EventMain {
    private List<Event> events = new ArrayList<>();
    private final String FILE_NAME = "events.ser";

    public EventMain() throws IOException, ClassNotFoundException {
        loadEventsFromFile();
    }
    public void createEvent(Event e) throws IOException {
        events.add(e);
        saveEventsToFile();
        System.out.println("Event Created:");
        e.eventDisplay();
    }
    public void editEvent(int eventId, String newTitle, String newDate, String newVenue, String newDesc) throws IOException {
        for (Event e : events) {
            if (e.getEventID() == eventId) {
                e.setTitle(newTitle);
                e.setDate(newDate);
                e.setVenue(newVenue);
                e.setDescription(newDesc);
                saveEventsToFile();
                System.out.println("Updated Event:");
                e.eventDisplay();
                return;
            }
        }
        System.out.println("Event not Found!");
    }
    public void deleteEvent(int eventID) throws IOException {
        boolean removed = events.removeIf(e -> e.getEventID() == eventID);
        if (removed) {
            saveEventsToFile();
            System.out.println("Event " + eventID + " was deleted.");
        } else {
            System.out.println("Event not Found!");
        }
    }
    public void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No Events Available.");
        } else {
            for (Event e : events) {
                e.eventDisplay();
            }
        }
    }
    private void saveEventsToFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        out.writeObject(events);
        out.close();
    }
    private void loadEventsFromFile() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        events = (List<Event>) in.readObject();
        in.close();
    }
}
