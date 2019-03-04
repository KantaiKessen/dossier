import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Write a description of class Display here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Display {
    static List<String> user = new ArrayList<>();
    static List<String> pass = new ArrayList<>();
    int lines = 0;
    public static void main(String[] args) {
        try {
            FTPDownloader downloader = new FTPDownloader("niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            downloader.downloadFile("/etc/users", "users");
            downloader.disconnect();

            int option = JOptionPane.showConfirmDialog(null, "Press yes for Login, no for Sign Up");
            if (option == 0) {
                login();
            } else {
                signup();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void login() {
        int fileLength = 0;
        try {
            Scanner countScanner = new Scanner(new File("users"));
            while(countScanner.hasNext()){
                fileLength++;
                countScanner.next();
            }
            countScanner.close();
            Scanner infile = new Scanner(new File("users"));
            String username = JOptionPane.showInputDialog("Enter username: ");
            for(int i = 0; i < fileLength; i++) {
                if()
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            String username = JOptionPane.showInputDialog("Enter username: ");
            if (usernameVerification(username)) {
                int index = 0;
                for (int j = 0; j < user.size(); j++) {
                    if (user.get(j).equalsIgnoreCase(username)) {
                        index = j;
                    }
                }
                String password = JOptionPane.showInputDialog("Enter password: ");
                passwordVerification(password, index);
            } else {
                JOptionPane.showInputDialog("Sorry, that username does not exist. Press cancel.");
            }
        } catch (NullPointerException e) {
            System.exit(0);
        }
    }

    public static void signup() {
        boolean in = false;
        String u = JOptionPane.showInputDialog("Enter username");
        do {
            if (in) {
                u = JOptionPane.showInputDialog("That username already exists. Choose a different one.");
            }
            in = false;
            for (String s : user) {
                if (s.equals(u))
                    in = true;
            }
        } while (in);
        user.add(u);
        pass.add(JOptionPane.showInputDialog("Choose a password."));
        JOptionPane.showInputDialog("Your account has been created. You will now be asked to log in.");
        login();
    }


    public static void passwordVerification(String p, int ind) {
        if (!pass.get(ind).equals(p)) {
            JOptionPane.showInputDialog("Incorrect password. Press cancel.");
        } else {
            //run program here
        }
    }
}
