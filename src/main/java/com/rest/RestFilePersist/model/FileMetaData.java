package com.rest.RestFilePersist.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fileMetaData")
@IdClass(FilePK.class)

public class FileMetaData {
	
	@Id
	private String uuid;
	
	private String fileName;	
	
	private String creatorName;
	
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fileDate;
	
	public FileMetaData()
	{
		
	}
	
	 public FileMetaData(String fileName, String creatorName,Date fileDate) {
		 
	        this(UUID.randomUUID().toString(), fileName,creatorName,fileDate);
	    }

	public FileMetaData(String uUID, String fileName, String creatorName, Date fileDate) {
		super();
		uuid = uUID;
		this.fileName = fileName;
		this.creatorName = creatorName;
		this.fileDate = fileDate;
	}


	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	
	
}
