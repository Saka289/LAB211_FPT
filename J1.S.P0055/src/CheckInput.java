
import java.util.ArrayList;
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
public class CheckInput {

    //Check input String để không có giá trị trùng lặp
    public String checkInputCode(String msg, ArrayList<Doctor> list) {
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
                for (Doctor doctor : list) {
                    if (doctor.getCode().equalsIgnoreCase(input)) {
                        throw new Error();
                    }
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Code is not null");
                loop = true;
            } catch (Error e) {
                System.out.println("Code is not duplicate");
            }

        } while (loop);
        return input;
    }

    //check input String không được rỗng 
    public String checkInput(String msg) {
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
                System.out.println("don't empty");
                loop = true;
            }
        } while (loop);
        return input;
    }

    // check int nhập vào với điều kiện input phải > 0
    public int getInt(String msg) {
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
                loop = false;
            } catch (Exception e) {
                System.out.println("is digit > 0");
                loop = true;
            }
        } while (loop);
        return input;
    }

    // check đúng sai chưa sử dụng 
    public boolean checkYN(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("please input Y or N");
                return true;
            }
        }
    }

    //Check String nhập vào có tồn tại hay ko nếu ko tồn tại hiện lỗi, tồn tại đi tiếp
    public String checkInputCode1(String msg, ArrayList<Doctor> list) {
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
                int count = 0;
                for (Doctor doctor : list) {
                    if (doctor.getCode().equalsIgnoreCase(input)) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Code is not null");
                loop = true;
            } catch (Error e) {
                System.out.println("Code does not exist");
            }

        } while (loop);
        return input;
    }

    //Check input String đã tồn tại hay chưa, tồn rồi đi tiếp, ko tồn tại hiện lỗi nhập lại
    public String checkInputName(String msg, ArrayList<Doctor> list) {
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
                int count = 0;
                for (Doctor doctor : list) {
                    if (input.equalsIgnoreCase(doctor.getName())) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    throw new Error();
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Name is not null");
                loop = true;
            } catch (Error e) {
                System.out.println("Name does not exist");
            }

        } while (loop);
        return input;
    }

    //Check int nhập vào với giới hạn max và min
    public int getInt(String msg, int min, int max) {
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
