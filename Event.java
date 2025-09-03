
public class Event {
    int eventID;
    String title;
    String date;
    String venue;
    String description;
    public Event(int eventID, String title, String date, String venue, String description) {
        this.eventID = eventID;
        this.title = title;
        this.date = date;
        this.venue = venue;
        this.description = description;
    }
    public int getEventID() {
        return eventID;
    }
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }  
    public void eventDisplay(){
       System.out.println("Event ID: "+this.eventID+"\nTitle: "+this.title+"\nDate: "+this.date+"\nVenue: "+this.venue+"\nDescription: "+this.description);
    }

}
