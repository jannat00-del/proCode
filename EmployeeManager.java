/*Task1. Update Code Style for Better Consistency
indentation,spacing,prope braces and line brakes
*/
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

                                                       // Task2 FIX : Early terminates fix
        if (args == null || args.length != 1) {
            System.out.println("Invalid number of arguments!");
            System.out.println("Usage: java EmployeeManager <option>");
            System.exit(1);
        }

        // Show All Employees
        if (args[0].equals("l")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                for (String employee : employees) {
                    System.out.println(employee.trim());
                }

                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                           // Random Employee  
        else if (args[0].equals("s")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                Random random = new Random();
                int randomIndex = random.nextInt(employees.length);

                System.out.println(employees[randomIndex].trim());   //Extra space removal= trim()

                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                      // Add Employee
        else if (args[0].contains("+")) {
            System.out.println("Loading data...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true)
                );

                String newEmployee = args[0].substring(1);
                writer.write(", " + newEmployee);

                writer.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                     // Search Employee
        else if (args[0].contains("?")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                boolean isFound = false;
                String searchName = args[0].substring(1);

                for (int i = 0; i < employees.length && !isFound; i++) {
                    if (employees[i].trim().equals(searchName)) {
                        System.out.println("Employee found!");
                        isFound = true;
                    }
                }

                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                           // Count Words
        else if (args[0].contains("c")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                char[] characters = line.toCharArray();

                boolean inWord = false;
                int wordCount = 0;

                for (char ch : characters) {
                    if (ch != ' ' && ch != ',') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println(wordCount + " word(s) found");

                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                         // Update Employee
        else if (args[0].contains("u")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                String updatedName = args[0].substring(1);

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(updatedName)) {
                        employees[i] = "updated";
                    }
                }

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", employees));

                writer.close();
                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Updated.");
        }

                                                      // Delete Employee
        else if (args[0].contains("d")) {
            System.out.println("Loading data...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String line = reader.readLine();
                String[] employees = line.split(",");

                String nameToDelete = args[0].substring(1);

                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(nameToDelete);

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                writer.write(String.join(",", employeeList));

                writer.close();
                reader.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
