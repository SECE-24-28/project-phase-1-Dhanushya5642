import java.util.List;
public class Employee {
    int employeeID;
    String name;
    String email;
    List<Integer> registeredEvents;
    public Employee(int employeeID, String name, String email, List<Integer> registeredEvents) {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.registeredEvents = registeredEvents;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Integer> getRegisteredEvents() {
        return registeredEvents;
    }
    public void setRegisteredEvents(List<Integer> registeredEvents) {
        this.registeredEvents = registeredEvents;
    }
    public void employeeDisplay(){
       System.out.println("Employee ID: "+this.employeeID+"\nName: "+this.name+"\nEmail: "+this.email+"\n: RegisteredEvents ID:"+this.registeredEvents);
    }
}
