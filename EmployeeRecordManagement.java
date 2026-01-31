import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary);
    }
}

public class EmployeeRecordManagement {

    static Scanner sc = new Scanner(System.in);

    static List<Employee> employeeList = new ArrayList<>();
    static Map<Integer, Employee> employeeMap = new HashMap<>();
    static Set<Integer> employeeIdSet = new HashSet<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Employee Record Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    viewEmployees();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add Employee
    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        if (employeeIdSet.contains(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employeeList.add(emp);
        employeeMap.put(id, emp);
        employeeIdSet.add(id);

        System.out.println("Employee added successfully!");
    }

    // Update Employee
    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();

        if (!employeeMap.containsKey(id)) {
            System.out.println("Employee not found!");
            return;
        }

        sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Department: ");
        String department = sc.nextLine();

        System.out.print("Enter new Salary: ");
        double salary = sc.nextDouble();

        Employee emp = employeeMap.get(id);
        emp.name = name;
        emp.department = department;
        emp.salary = salary;

        System.out.println("Employee details updated!");
    }

    // Delete Employee
    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        if (!employeeMap.containsKey(id)) {
            System.out.println("Employee not found!");
            return;
        }

        Employee emp = employeeMap.get(id);
        employeeList.remove(emp);
        employeeMap.remove(id);
        employeeIdSet.remove(id);

        System.out.println("Employee deleted successfully!");
    }

    // View Employees
    static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.println("\nEmployee Records:");
        for (Employee emp : employeeList) {
            emp.display();
        }
    }

    // Search Employee
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        if (employeeMap.containsKey(id)) {
            employeeMap.get(id).display();
        } else {
            System.out.println("Employee not found!");
        }
    }
}