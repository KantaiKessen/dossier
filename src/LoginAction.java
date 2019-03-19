import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAction {
    public void loginAction(String name, String pass) {
        int numLines = 0;

        try {
            FTPDownloader ftp = new FTPDownloader(
                    "niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            ftp.downloadFile("/etc/users", "users");
            Scanner scanner = new Scanner(new File("users"));
            while (scanner.hasNext()) {
                numLines++;
                scanner.next();
            }
            scanner.close();
            scanner = new Scanner(new File("users"));
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
        } catch (FileNotFoundException eb) {
            eb.printStackTrace();
        } catch (Exception ea) {
            ea.printStackTrace();
            AlertBox.display("Database is down", "The database is down and cannot be accessed." +
                    "Please call the officer of the deck in any case not covered by instructions");
        }
    }

    private boolean isInUserFile(String name, String[][] a) {
        for (String x : a[0]) {
            if (x.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
