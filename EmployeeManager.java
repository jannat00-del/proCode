/*Task1. Update Code Style for Better Consistency
indentation,spacing,prope braces and line brakes
*/
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static String[] readEmployees() throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(Constants.FILE_NAME))
        );
        String line = reader.readLine();
        reader.close();
        return line.split(Constants.COMMA);
    }

    private static void writeEmployees(String data) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.FILE_NAME)
        );
        writer.write(data);
        writer.close();
    }

    private static void appendEmployee(String newEmployee) throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.FILE_NAME, true)
        );
        writer.write(Constants.COMMA_SPACE + newEmployee);
        writer.close();
    }

    
    public static void main(String[] args) {

        if (args == null || args.length != 1) {
            System.out.println(Constants.INVALID_ARGUMENT);
            System.out.println(Constants.USAGE);
            System.exit(1);
        }

        .
        
                                                              // Show all employees
        if (args[0].equals(Constants.SHOW_ALL)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                for (String emp : readEmployees()) {
                    System.out.println(emp.trim());
                }
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                 // Random employee
        else if (args[0].equals(Constants.SHOW_RANDOM)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String[] employees = readEmployees();
                System.out.println(
                    employees[new Random().nextInt(employees.length)].trim()
                );
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                                  // Add new employee
        else if (args[0].contains(Constants.ADD_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                appendEmployee(args[0].substring(1));   // removed temp variable
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                                // Search employee
        else if (args[0].contains(Constants.SEARCH_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                boolean found = false;
                for (String emp : readEmployees()) {
                    if (emp.trim().equals(args[0].substring(1))) { // direct use
                        System.out.println(Constants.EMPLOYEE_FOUND);
                        found = true;
                        break;
                    }
                }
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                               // Count words
        else if (args[0].contains(Constants.COUNT_WORDS)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                int wordCount = 0;
                for (String emp : readEmployees()) {
                    if (!emp.trim().isEmpty()) wordCount++;
                }
                System.out.println(wordCount + Constants.WORD_FOUND_SUFFIX);
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                                // Update employee
        else if (args[0].contains(Constants.UPDATE_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String[] employees = readEmployees();
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(args[0].substring(1))) {
                        employees[i] = "updated";
                    }
                }
                writeEmployees(String.join(Constants.COMMA, employees));
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_UPDATED);
        }

                                                                      // Delete employee
        else if (args[0].contains(Constants.DELETE_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                List<String> empList = new ArrayList<>();
                for (String emp : readEmployees()) {
                    if (!emp.trim().equals(args[0].substring(1))) {
                        empList.add(emp.trim());
                    }
                }
                writeEmployees(String.join(Constants.COMMA_SPACE, empList));
            } catch (Exception ignored) {}
            System.out.println(Constants.DATA_DELETED);
        }
    }
}
