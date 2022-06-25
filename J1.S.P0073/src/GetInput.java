
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saka
 */
public class GetInput {

//    private static final Pattern dateRegexPattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");
    public double getDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        double input = 0;
        do {
            System.out.print(msg);
            try {
                input = Double.parseDouble(sc.nextLine().trim());
                if (input <= 0) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Error format!!!");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public String getDate() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date;
        while (true) {
            try {
                date = new SimpleDateFormat("dd-MM-yyyy").parse(getStringDate("Enter Date(dd-mm-yyyy): "));
                break;
            } catch (ParseException e) {
                System.err.println("invalid date (dd-MM-yyyy), please input again: ");
            }
        }
        return df.format(date);
    }

    public String getStringDate(String msg) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        boolean loop = true;
        String date = "";
        do {
            System.out.print(msg);
            try {
                date = sc.nextLine();
                if (date.isEmpty()) {
                    throw new Error();
                }
                dateFormat.setLenient(false);
                dateFormat.parse(date);
                loop = false;
            } catch (Exception e) {
                System.out.println("Error format!!!");
                loop = true;
            } catch (Error e) {
                System.out.println("Date not empty!!!");
            }
        } while (loop);
        return date;
    }

//    public String getStringDate(String msg, String regex) {
//        Scanner sc = new Scanner(System.in);
//        boolean loop = true;
//        String input = "";
//        do {
//            System.out.print(msg);
//            try {
//                input = sc.nextLine().trim();
//                if (input.isEmpty()) {
//                    throw new Exception();
//                }
//                if (!input.matches(regex)) {
//                    throw new Error();
//                }
//                loop = false;
//            } catch (Exception e) {
//                System.out.println("Date not empty");
//                loop = true;
//            } catch (Error e) {
//                System.out.println("Error format");
//            }
//        } while (loop);
//        return input;
//    }
//    public String getStringDate(String msg) {
//        Scanner sc = new Scanner(System.in);
//        boolean loop = true;
//        String date = "";
//        do {
//            System.out.print(msg);
//            try {
//                date = sc.nextLine();
//                Matcher dateMatcher = dateRegexPattern.matcher(date);
//                if (dateMatcher.matches()) {
//                    dateMatcher.reset();
//                    if (dateMatcher.find()) {
//                        String day = dateMatcher.group(1);
//                        String month = dateMatcher.group(2);
//                        int year = Integer.parseInt(dateMatcher.group(3));
//                        if ("31".equals(day)
//                                && ("4".equals(month) || "6".equals(month) || "9".equals(month)
//                                || "11".equals(month) || "04".equals(month) || "06".equals(month)
//                                || "09".equals(month))) {
//                            throw new Exception();
//                        } else if ("2".equals(month) || "02".equals(month)) {
//                            //leap year
//                            if (year % 4 == 0) {
//                                if (!"30".equals(day) && !"31".equals(day)) {
//                                    loop = false;
//                                }
//                            } else {
//                                if (!"29".equals(day) && !"30".equals(day) && !"31".equals(day)) {
//                                    loop = false;
//                                }
//                            }
//                        } else {
//                            loop = false;
//                        }
//                    } else {
//                        throw new Exception();
//                    }
//                } else {
//                    throw new Exception();
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid date!!!");
//                loop = true;
//            }
//        } while (loop);
//        return date;
//    }
    public String getStringContent(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String input = "";
        do {
            System.out.print(msg);
            try {
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Content not empty");
                loop = true;
            }
        } while (loop);
        return input;
    }

    public int getID(String msg, ArrayList<Expense> list) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input <= 0) {
                    throw new Exception();
                }
                int count = 0;
                for (Expense expense : list) {
                    if (expense.getID() == input) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("ID is digit");
            } catch (Error e) {
                System.out.println("Delete an expense fail");
            }
        } while (loop);
        return input;
    }

    public int getIntLimit(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int input = 0;
        do {
            System.out.print(msg);
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    throw new Exception();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Input must be integer !!!");
                loop = true;
            }
        } while (loop);
        return input;
    }
}
