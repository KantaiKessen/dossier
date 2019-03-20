package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAction {
    public static boolean loginAction(String name, String pass) {
        int numLines = 0;

        try {
            Scanner scanner = new Scanner(new File("teacher"));
            while (scanner.hasNext()) {
                numLines++;
                scanner.next();
            }
            scanner.close();
            scanner = new Scanner(new File("teacher"));
            String[][] userData = new String[2][];
            userData[0] = new String[numLines];
            userData[1] = new String[numLines];
            for (int i = 0; i < numLines; i++) {
                String[] data = scanner.next().split(":");
                userData[0][i] = data[0];
                userData[1][i] = data[1];
            }
            if (!isInUserFile(name, userData)) {
                AlertBox.display("User not found", "The user does not exist");
            }
            else{
                if (!isInPasswordFile(SecurityFeatures.getMD5(pass),userData)){
                    AlertBox.display("Incorret password", "The user does not exist");
                }
                else {return true;}
            }
        } catch (FileNotFoundException eb) {
            eb.printStackTrace();
        }
        return false;
    }

    private static boolean isInUserFile(String name, String[][] a) {
        for (String x : a[0]) {
            if (x.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInPasswordFile(String hash, String[][] a) {
        for (String x : a[1]) {
            if (x.equals(hash)) {
                return true;
            }
        }
        return false;
    }
}
