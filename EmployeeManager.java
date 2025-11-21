/*Task1. Update Code Style for Better Consistency
indentation,spacing,prope braces and line brakes
*/
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {

    public static void main(String[] args) {

                                                           // TASK 2 FIX: Early terminates fix
        if (args == null || args.length != 1) {
            System.out.println("Invalid number of arguments!");
            System.out.println("Usage: java EmployeeManager <option>");
            System.exit(1);
        }
        

        // Show All Employees
        if (args[0].equals("l")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                String[] e = l.split(",");

                for (String emp : e) {
                    System.out.println(emp.trim());
                }

                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                          // Random Employee  
        else if (args[0].equals("s")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                String[] e = l.split(",");

                Random rand = new Random();
                int idx = rand.nextInt(e.length);

                System.out.println(e[idx].trim());    //Extra space removel = trim()
                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                         // Add Employee
        else if (args[0].contains("+")) {
            System.out.println("Loading data...");
            try {
                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt", true)
                );

                String n = args[0].substring(1);
                w.write(", " + n);
                w.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                    // Search Employee
        else if (args[0].contains("?")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                String[] e = l.split(",");

                boolean found = false;
                String s = args[0].substring(1);

                for (int i = 0; i < e.length && !found; i++) {
                    if (e[i].trim().equals(s)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }

                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                           // Count Words
        else if (args[0].contains("c")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                char[] chars = l.toCharArray();

                boolean inWord = false;
                int count = 0;

                for (char c : chars) {
                    if (c != ' ' && c != ',') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println(count + " word(s) found");
                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Loaded.");
        }

                                                                 // Update Employee
        else if (args[0].contains("u")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                String[] e = l.split(",");

                String n = args[0].substring(1);

                for (int i = 0; i < e.length; i++) {
                    if (e[i].trim().equals(n)) {
                        e[i] = "updated";
                    }
                }

                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                w.write(String.join(",", e));
                w.close();
                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Updated.");
        }

                                                                   // Delete Employee
        else if (args[0].contains("d")) {
            System.out.println("Loading data...");
            try {
                BufferedReader r = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")
                        )
                );

                String l = r.readLine();
                String[] e = l.split(",");

                String n = args[0].substring(1);

                List<String> list = new ArrayList<>(Arrays.asList(e));
                list.remove(n);

                BufferedWriter w = new BufferedWriter(
                        new FileWriter("employees.txt")
                );

                w.write(String.join(",", list));
                w.close();
                r.close();
            } catch (Exception ex) {
            }
            System.out.println("Data Deleted.");
        }
    }
}