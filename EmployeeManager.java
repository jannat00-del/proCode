/*Task1. Update Code Style for Better Consistency
indentation,spacing,prope braces and line brakes
*/
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class EmployeeManager {

    private static final String FILE_NAME = "employees.txt";

    

    private static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME))
        );
        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }

    private static void writeEmployees(String data) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME)
        );
        writer.write(data);
        writer.close();
    }

    private static void appendEmployee(String newEmployee) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME, true)
        );
        writer.write(", " + newEmployee);
        writer.close();
    }

    

    public static void main(String[] args) {

        // Task2 Fix: 
        if (args == null || args.length != 1) {
            System.out.println("Invalid number of arguments!");
            System.out.println("Usage: java EmployeeManager <option>");
            System.exit(1);
        }

        String command = args[0];


        if (command.equals("l")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();
                for (String emp : employees) {
                    System.out.println(emp.trim());
                }
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        }

        
        else if (command.equals("s")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();
                Random rand = new Random();
                int index = rand.nextInt(employees.length);
                System.out.println(employees[index].trim());
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        }

        
        else if (command.contains("+")) {
            System.out.println("Loading data...");
            try {
                String newEmployee = command.substring(1);
                appendEmployee(newEmployee);
            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        }

        
        else if (command.contains("?")) {
            System.out.println("Loading data...");
            try {
                String searchName = command.substring(1);
                String[] employees = readEmployees();

                // Task 7: 
                for (String emp : employees) {
                    if (emp.trim().equals(searchName)) {
                        System.out.println("Employee '" + searchName + "' FOUND in system.");
                        System.out.println("Search complete.");
                        System.out.println("Data Loaded.");
                        return;
                    }
                }

                
                System.out.println("Employee '" + searchName + "' NOT FOUND.");
                System.out.println("Search complete.");

            } catch (Exception ex) {
                System.out.println("Error reading data.");
            }
            System.out.println("Data Loaded.");
        }

        
        else if (command.contains("c")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();

                // Task 8: Simplified count using streams
                long count = Arrays.stream(employees)
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .count();

                System.out.println(count + " word(s) found");

            } catch (Exception ex) {}
            System.out.println("Data Loaded.");
        }

        
        else if (command.contains("u")) {
            System.out.println("Loading data...");
            try {
                String updatedName = command.substring(1);
                String[] employees = readEmployees();

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(updatedName)) {
                        employees[i] = "updated";
                    }
                }

                writeEmployees(String.join(",", employees));

            } catch (Exception ex) {}
            System.out.println("Data Updated.");
        }

        
        else if (command.contains("d")) {
            System.out.println("Loading data...");
            try {
                String deleteName = command.substring(1);
                String[] employees = readEmployees();

                List<String> updatedList = Arrays.stream(employees)
                        .map(String::trim)
                        .filter(name -> !name.equals(deleteName))
                        .collect(Collectors.toList());

                writeEmployees(String.join(", ", updatedList));

            } catch (Exception ex) {}
            System.out.println("Data Deleted.");
        }

    }
}
