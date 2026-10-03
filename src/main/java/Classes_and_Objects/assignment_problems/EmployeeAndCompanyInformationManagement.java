public class EmployeeAndCompanyInformationManagement {
    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Asha", 50000);
        new Employee("Ravi", 45000);
        new Employee("Neha", 40000);
        Employee.printCompanyInfo();
    }
}
