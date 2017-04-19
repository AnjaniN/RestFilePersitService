package com.rest.RestFilePersist.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;


public class Document extends FileMetaData implements Serializable {

    
    
    private byte[] fileData;
    
    public Document( byte[] fileData, String fileName,  String creatorName,Date fileDate) {
        super(fileName,creatorName,fileDate);
        this.fileData = fileData;
    }

   
    
    public Document(FileMetaData metadata) {
        super(metadata.getUuid(), metadata.getFileName(),metadata.getCreatorName(),metadata.getFileDate());
    }

    public byte[] getFileData() {
        return fileData;
    }
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
    public FileMetaData getMetadata() {
        return new FileMetaData(getUuid(), getFileName(),getCreatorName(), getFileDate());
    }
    
}
