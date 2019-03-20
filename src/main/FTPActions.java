package main;

public class FTPActions {
    public static void downloadFiles(){
        try {
            FTPDownloader ftpDown = new FTPDownloader("niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            ftpDown.downloadFile("/etc/teacher", "teacher");
            ftpDown.downloadFile("/etc/student", "student");
            ftpDown.downloadFile("/etc/tutor", "tutor");
            ftpDown.downloadFile("/etc/match", "match");
            ftpDown.disconnect();
        }catch (Exception e){
            AlertBox.display("FTP ERROR", "The database is down. Please try again soon");
        }
    }

    public static void uploadFiles(){
        try {
            FTPUploader ftpUp = new FTPUploader("niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            ftpUp.uploadFile("./teacher", "teacher", "/etc/");
            ftpUp.uploadFile("./student", "student", "/etc/");
            ftpUp.uploadFile("./tutor", "tutor", "/etc/");
            ftpUp.uploadFile("./match", "match", "/etc/");
            ftpUp.disconnect();
        }catch (Exception e){
            AlertBox.display("FTP ERROR", "The database is down. Please try again later");
        }
    }


}
