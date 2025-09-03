import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventMain eventMain = new EventMain();
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\nEvent Management System:");
            System.out.println("1. Manager Menu");
            System.out.println("2. Employee Menu");
            System.out.println("3. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) { 
                System.out.println("\nMANAGER MENU:");
                System.out.println("1. Create Event");
                System.out.println("2. Edit Event");
                System.out.println("3. Delete Event");
                System.out.println("4. View Events");
                int opt = sc.nextInt(); sc.nextLine();

                if (opt == 1) {
                    System.out.print("Event ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Date: "); String date = sc.nextLine();
                    System.out.print("Venue: "); String venue = sc.nextLine();
                    System.out.print("Description: "); String desc = sc.nextLine();
                    eventMain.createEvent(new Event(id, title, date, venue, desc));

                } else if (opt == 2) {
                    System.out.print("Enter Event ID to edit: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("New Title: "); String title = sc.nextLine();
                    System.out.print("New Date: "); String date = sc.nextLine();
                    System.out.print("New Venue: "); String venue = sc.nextLine();
                    System.out.print("New Description: "); String desc = sc.nextLine();
                    eventMain.editEvent(id, title, date, venue, desc);

                } else if (opt == 3) {
                    System.out.print("Enter Event ID to delete: "); int id = sc.nextInt();
                    eventMain.deleteEvent(id);

                } else if (opt == 4) {
                    eventMain.viewEvents();
                }
            }

            else if (choice == 2) {
                System.out.print("Enter Employee ID: ");
                int empId = sc.nextInt(); sc.nextLine();
                Employee emp = null;
                for (Employee e : employees) {
                    if (e.getEmployeeID() == empId) emp = e;
                }
                if (emp == null) {
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Email: "); String email = sc.nextLine();
                    emp = new Employee(empId, name, email, new ArrayList<>());
                    employees.add(emp);
                }

                System.out.println("\nEMPLOYEE MENU:");
                System.out.println("1. View Events");
                System.out.println("2. Register for Event");
                System.out.println("3. View My Registrations");
                int opt = sc.nextInt(); sc.nextLine();

                if (opt == 1) {
                    eventMain.viewEvents();

                } else if (opt == 2) {
                    System.out.print("Enter Event ID to register: ");
                    int evId = sc.nextInt();
                    emp.getRegisteredEvents().add(evId);
                    saveEmployees(employees);

                } else if (opt == 3) {
                    emp.employeeDisplay();
                }
            }

            else {
                System.out.println("Exited Successfully");
                break;
            }
        }
        sc.close();
    }
    private static void saveEmployees(List<Employee> employees) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("employees.txt"))) {
            for (Employee emp : employees) {
                pw.println(emp.getEmployeeID() + "|" + emp.getName() + "|" +
                           emp.getEmail() + "|" + emp.getRegisteredEvents());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
