import java.io.IOException;

public class FTPActions {
    public static void downloadFiles(){
        try {
            FTPDownloader ftpDown = new FTPDownloader("niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            ftpDown.downloadFile("/etc/teacher", "teacher");
            ftpDown.disconnect();
        }catch (Exception e){
            AlertBox.display("FTP ERROR", "The database is down. Please try again soon");
        }
    }


}
