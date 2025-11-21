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

        String option = args[0];

        
        if (option.equals(Constants.SHOW_ALL)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String[] employees = readEmployees();

                for (String emp : employees) {
                    System.out.println(emp.trim());
                }

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        }

        else if (option.equals(Constants.SHOW_RANDOM)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String[] employees = readEmployees();
                Random rand = new Random();

                int randomIndex = rand.nextInt(employees.length);
                System.out.println(employees[randomIndex].trim());

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                             // Add employee 
        else if (option.contains(Constants.ADD_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String newEmployee = option.substring(1);
                appendEmployee(newEmployee);

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                   // Search employee 
        else if (option.contains(Constants.SEARCH_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String searchName = option.substring(1);
                String[] employees = readEmployees();

                boolean found = false;

                for (String emp : employees) {
                    if (emp.trim().equals(searchName)) {
                        System.out.println(Constants.EMPLOYEE_FOUND);
                        found = true;
                        break;
                    }
                }

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                                // Count words 
        else if (option.contains(Constants.COUNT_WORDS)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String[] employees = readEmployees();

                int wordCount = 0;

                for (String emp : employees) {
                    if (!emp.trim().isEmpty()) {
                        wordCount++;
                    }
                }

                System.out.println(wordCount + Constants.WORD_FOUND_SUFFIX);

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_LOADED);
        }

                                                             //  Update employee 
        else if (option.contains(Constants.UPDATE_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String updatedName = option.substring(1);
                String[] employees = readEmployees();

                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].trim().equals(updatedName)) {
                        employees[i] = "updated";
                    }
                }

                writeEmployees(String.join(Constants.COMMA, employees));

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_UPDATED);
        }

                                                                              //  Delete
        else if (option.contains(Constants.DELETE_EMP)) {
            System.out.println(Constants.LOADING_DATA);
            try {
                String nameToDelete = option.substring(1);
                String[] employees = readEmployees();

                List<String> empList = new ArrayList<>();

                for (String emp : employees) {
                    if (!emp.trim().equals(nameToDelete)) {
                        empList.add(emp.trim());
                    }
                }

                writeEmployees(String.join(Constants.COMMA_SPACE, empList));

            } catch (Exception ex) {}
            System.out.println(Constants.DATA_DELETED);
        }
    }
}
