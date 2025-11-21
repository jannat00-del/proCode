/*Task1. Update Code Style for Better Consistency
indentation,spacing,prope braces and line brakes
*/
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static final String FILE_NAME = "employees.txt";

                                                       //  Reader File 
    private static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(FILE_NAME))
        );

        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }

                                                              //  Writer File
    private static void writeEmployees(String data) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME)
        );

        writer.write(data);
        writer.close();
    }

                                                                // Append New Employee 
    private static void appendEmployee(String newEmployee) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME, true)
        );

        writer.write(", " + newEmployee);
        writer.close();
    }

    // ------------------------------------------------------------------

    public static void main(String[] args) {

                                                              // Task2 Fix: Early terminates fix
        if (args == null || args.length != 1) {
            System.out.println("Invalid number of arguments!");
            System.out.println("Usage: java EmployeeManager <option>");
            System.exit(1);
        }

                                                                    // All Employees (l)
        if (args[0].equals("l")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();

                for (String emp : employees) {
                    System.out.println(emp.trim());
                }

            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                      // Show Random Employee 
        else if (args[0].equals("s")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();
                Random rand = new Random();

                int randomIndex = rand.nextInt(employees.length);
                System.out.println(employees[randomIndex].trim());

            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                   // Add New Employee 
        else if (args[0].contains("+")) {
            System.out.println("Loading data...");
            try {
                String newEmployee = args[0].substring(1);
                appendEmployee(newEmployee);
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                  // Search Employee 
        else if (args[0].contains("?")) {
            System.out.println("Loading data...");
            try {
                String searchName = args[0].substring(1);
                String[] employees = readEmployees();

                boolean found = false;

                for (String emp : employees) {
                    if (emp.trim().equals(searchName)) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }

            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                             // Count Words 
        else if (args[0].contains("c")) {
            System.out.println("Loading data...");
            try {
                String[] employees = readEmployees();

                int wordCount = 0;

                for (String emp : employees) {
                    if (!emp.trim().isEmpty()) {
                        wordCount++;
                    }
                }

                System.out.println(wordCount + " word(s) found");

            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                       // Update Employee 
        else if (args[0].contains("u")) {
            System.out.println("Loading data...");
            try {
                String updatedName = args[0].substring(1);
                String[] employees = readEmployees();

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(updatedName)) {
                        employees[i] = "updated";
                    }
                }

                writeEmployees(String.join(",", employees));

            } catch (Exception ex) {
            }
            System.out.println("Data Updated.");
        }

                                                                          // Delete Employee 
        else if (args[0].contains("d")) {
            System.out.println("Loading data...");
            try {
                String nameToDelete = args[0].substring(1);
                String[] employees = readEmployees();

                List<String> empList = new ArrayList<>();

                for (String emp : employees) {
                    if (!emp.trim().equals(nameToDelete)) {
                        empList.add(emp.trim());
                    }
                }

                writeEmployees(String.join(", ", empList));

            } catch (Exception ex) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
