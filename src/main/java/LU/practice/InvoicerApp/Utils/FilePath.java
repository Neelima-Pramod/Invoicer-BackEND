package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.Utils.Enums.FileTypes;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FilePath {
    private String userId;
    private String subFolderPath;
    private String uuid;
    private FileTypes fileTypes;
    private String fileUploadDir;

    public FilePath(String userId,FileTypes fileType) {
        this.userId = userId;
        this.fileUploadDir = "/home/neelima/FileUploads/";
        this.subFolderPath = generateSubFolder();
        this.uuid = UUID.randomUUID().toString();
        this.fileTypes=fileType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubFolderPath() {
        return subFolderPath;
    }

    public void setSubFolderPath(String subFolderPath) {
        this.subFolderPath = subFolderPath;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public FileTypes getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(FileTypes fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getFileUploadDir() {
        return fileUploadDir;
    }

    public void setFileUploadDir(String fileUploadDir) {
        this.fileUploadDir = fileUploadDir;
    }

    private String getFormattedDate(){
        ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"));
        return now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    private String generateSubFolder(){
        return userId+ File.separator+getFormattedDate();
    }

    //fileUploadDir+subFolderPath+fileName(uuid.filetype)

    private String fileName(){
        return this.uuid +"."+this.fileTypes.small;
    }

    public String fullPath(){
        return this.fileUploadDir + this.subFolderPath + File.separator + this.fileName();
    }
}
